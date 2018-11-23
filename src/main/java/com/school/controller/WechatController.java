package com.school.controller;

import com.school.dataobject.Result;
import com.school.dataobject.Student;
import com.school.dataobject.User;
import com.school.service.StudentService;
import com.school.service.UserService;
import com.school.utils.CommonUtil;
import com.school.utils.HttpRequest;
import com.school.utils.ResultUtil;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by 廖师兄
 * 2017-07-03 01:20
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    WebSocketTest webSocketTest =new WebSocketTest();


//    @Autowired
//    private ProjectUrlConfig projectUrlConfig;

    /**
     * 微信公众二维码扫描的跳转接口
     * @param returnUrl
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        System.out.println("调用authorize方法");
        //1. 配置
        //2. 调用方法
        //授权后跳转的接口
        String url ="http://test.socialcontactblog.com/school-0.0.1-SNAPSHOT/wechat/userInfo";
        //构建一个微信授权登陆的url
        // url是授权后跳转的接口,第二个参数是scope，第三个参数是授权后跳转的接口所携带的参数
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        System.out.println("调用userInfo方法");
//        System.out.println("Received: " + message);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            System.out.println(code);
            System.out.println(wxMpOAuth2AccessToken);
            String openId = wxMpOAuth2AccessToken.getOpenId();
            System.out.println(openId);
            String access_token=wxMpOAuth2AccessToken.getAccessToken();
            String result=HttpRequest.sendGet("https://api.weixin.qq.com/sns/userinfo", "access_token="+access_token+"&openid="+openId+"&lang=zh_CN");
            String json = new String(result.getBytes("GBK"), "UTF-8");
            System.out.println(json);
            webSocketTest.sendMessage(json);
            //没有方括号
            JSONObject j = JSONObject.fromObject(json);
//            System.out.println(j);
//            System.out.println(j.getString("nickname"));
            String nickname = j.getString("nickname");
            String avatarUrl = j.getString("headimgurl");
            returnUrl = returnUrl+"?nickname="+nickname+"&avatarUrl="+avatarUrl;
//            String strString = json.substring(2);
//            net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(strString);
            //有方括号
//            JSONArray jsonArray = JSONArray.fromObject(json);

//            Object[] os = jsonArray .toArray();
//            JSONObject jsonObj = JSONObject.fromObject(os[0]);
//            System.out.println(obj.getString("nickname"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:" + returnUrl ;
    }

    /**
     * 微信公众号用户注册
     * @param code
     */
    @GetMapping("/registered")
    @ResponseBody
    public void registered(@RequestParam("code") String code) {
        System.out.println("调用registered方法");
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            System.out.println(code);
            System.out.println(wxMpOAuth2AccessToken);
            String openId = wxMpOAuth2AccessToken.getOpenId();
            System.out.println(openId);
            String access_token=wxMpOAuth2AccessToken.getAccessToken();
            String result=HttpRequest.sendGet("https://api.weixin.qq.com/sns/userinfo", "access_token="+access_token+"&openid="+openId+"&lang=zh_CN");
            String json = new String(result.getBytes("GBK"), "UTF-8");
            JSONObject j = JSONObject.fromObject(json);
//            System.out.println(j.getString("nickname"));
            User user = new User();
            user.setAvatarUrl(j.getString("headimgurl"));
            user.setNickName(j.getString("nickname"));
            user.setOpenId(j.getString("openid"));
            if(userService.selectUser(openId)==null){
                userService.addUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private UserService userService;

    /**
     * 教师
     * 微信小程序注册
     */
    @ResponseBody
    @RequestMapping(value = "/userCreat", method = RequestMethod.GET) // 获取用户信息
    public Result<User> userCreat(@Param("code") String code, @RequestParam("headurl") String headurl,
                            @RequestParam("nickname") String nickname) {
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        try {
                String requestUrl = WX_URL.replace("APPID", "wxf02bba0743954e7f").replace("SECRET", "039133d516cca7a7e3ca315d7876bb3f")
                        .replace("JSCODE", code).replace("authorization_code", "authorization_code");
                JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
                String openid = jsonObject.getString("openid");
                User user = new User();
                user.setOpenId(openid);
                user.setNickName(nickname);
                user.setAvatarUrl(headurl);
                return ResultUtil.success(userService.addUser(user));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1,"错误");
        }
    }

    @Autowired
    private StudentService studentService;

    /**
     * 学生
     * 微信小程序注册
     */
    @ResponseBody
    @RequestMapping(value = "/studentCreat", method = RequestMethod.GET) // 获取用户信息
    public Result<Student> studentCreat(@Param("code") String code, @RequestParam("headurl") String headurl,
                                  @RequestParam("nickname") String nickname) {
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        try {
            String requestUrl = WX_URL.replace("APPID", "wxf02bba0743954e7f").replace("SECRET", "039133d516cca7a7e3ca315d7876bb3f")
                    .replace("JSCODE", code).replace("authorization_code", "authorization_code");
            JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
            String openid = jsonObject.getString("openid");
            Student student = new Student();
            student.setOpenId(openid);
            student.setNickName(nickname);
            student.setAvatarUrl(headurl);
            return ResultUtil.success(studentService.addStudent(student));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1,"错误");
        }
    }

    @GetMapping("/tiaozhuan")
    @ResponseBody
    public String tiaozhuan(String code){

        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        System.out.println("一号位置");
        try {
            System.out.println("二号位置");

            System.out.println(WX_URL);

            String requestUrl = WX_URL.replace("APPID", "wxf02bba0743954e7f").replace("SECRET", "039133d516cca7a7e3ca315d7876bb3f")
                    .replace("JSCODE", code).replace("authorization_code", "authorization_code");

            System.out.println(requestUrl);

            System.out.println("三号位置");

            JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

            System.out.println(jsonObject);

//            webSocketTest.sendObject(jsonObject);
            webSocketTest.sendMessage(jsonObject.toString());

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    @GetMapping("/xiaochengxu")
    @ResponseBody
    public void xiaochengxu(@RequestParam("headurl") String headurl,
                           @RequestParam("nickname") String nickname) {
        System.out.println("调用xiaochengxu方法");
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            System.out.println("一号位置");
            JSONObject jsonObject = new JSONObject();
            System.out.println("二号位置");
            jsonObject.accumulate("headurl",headurl);
            System.out.println("三号位置");
            jsonObject.accumulate("nickname",nickname);
            System.out.println("四号位置");
            System.out.println(jsonObject.toString());
            webSocketTest.sendMessage(jsonObject.toString());
            System.out.println("五号位置");
//            JSONObject j = JSONObject.fromObject(json);
//            String nickname = j.getString("nickname");
//            String avatarUrl = j.getString("headimgurl");
//            returnUrl = returnUrl+"?nickname="+nickname+"&avatarUrl="+avatarUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }

//        return "redirect:" + returnUrl ;
    }

}
