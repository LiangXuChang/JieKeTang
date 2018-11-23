package com.school.controller;

import com.school.dataobject.Code;
import com.school.dataobject.Result;
import com.school.service.CodeService;
import com.school.utils.CommonUtil;
import com.school.utils.QRCodeUtil;
import com.school.utils.ResultUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by 梁栩菖
 * 2018/10/25 17:36
 */
@RestController
@RequestMapping("/classroom")
public class LoginController {

    @Autowired
    private CodeService codeService;

    WebSocketTest webSocketTest = new WebSocketTest();

    /**
     * 生成微信公众平台二维码
     * @param id
     * @return
     */
//    @GetMapping("/code")
//    public Result<Code> addQuestion(String id){
//        String link = "http://test.socialcontactblog.com/school-0.0.1-SNAPSHOT/wechat/authorize?returnUrl=http://test.socialcontactblog.com/img/index.html";
//        String destPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
//        String imgPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\20181029215148.jpg";
//        try {
//            System.out.println("测试成功");
//            QRCodeUtil.encode(link,imgPath,destPath,true,id);
//            String url="test.socialcontactblog.com/img/"+id+".jpg";
//            Code code = new Code();
//            code.setCId(id);
//            code.setCodeUrl(url);
//
//            System.out.println(url);
//            return ResultUtil.success(codeService.saveCode(code));
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//      return ResultUtil.error(1,"获取url失败");
//
//    }
    @GetMapping("/code")
    public Result<Code> addQuestion(String id){
        String link = "http://test.socialcontactblog.com/school-0.0.1-SNAPSHOT/wechat/xiaochengxu";
        String destPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
        String imgPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\20181029215148.jpg";
        try {
            System.out.println("测试成功");
            QRCodeUtil.encode(link,imgPath,destPath,true,id);
            String url="test.socialcontactblog.com/img/"+id+".jpg";
            Code code = new Code();
            code.setCId(id);
            code.setCodeUrl(url);

            System.out.println(url);
            return ResultUtil.success(codeService.saveCode(code));

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.error(1,"获取url失败");

    }

    @GetMapping("/qiandaocode")
    public Result<Code> qiandao(String openId){
        String link = "http://test.socialcontactblog.com/school-0.0.1-SNAPSHOT/classroom/sign/creat?openId="+openId;
        String destPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
        String imgPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\20181029215148.jpg";
        try {
            System.out.println("测试成功");
            QRCodeUtil.encode(link,imgPath,destPath,true,openId);
            String url="test.socialcontactblog.com/img/"+openId+".jpg";
            Code code = new Code();
            code.setCId(openId);
            code.setCodeUrl(url);

            System.out.println(url);
            return ResultUtil.success(codeService.saveCode(code));

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.error(1,"获取url失败");

    }

    @GetMapping("/login")
    public Result<Code> login(String id){
        String link = "http://test.socialcontactblog.com/school-0.0.1-SNAPSHOT/wechat/tiaozhuan";
        String destPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
        String imgPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\20181029215148.jpg";
        try {
            System.out.println("测试成功");
            QRCodeUtil.encode(link,imgPath,destPath,true,id);
            String url="test.socialcontactblog.com/img/"+id+".jpg";
            Code code = new Code();
            code.setCId(id);
            code.setCodeUrl(url);

            System.out.println(url);
            return ResultUtil.success(codeService.saveCode(code));

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.error(1,"获取url失败");

    }

//    @GetMapping("/tiaozhuan")
//    public void tiaozhuan(String code){
//
//        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
//        System.out.println("一号位置");
//        try {
//            System.out.println("二号位置");
//
//            String requestUrl = WX_URL.replace("APPID", "wxf02bba0743954e7f").replace("SECRET", "039133d516cca7a7e3ca315d7876bb3f")
//                    .replace("JSCODE", code).replace("authorization_code", "authorization_code");
//
//            System.out.println("三号位置");
//
//            JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
//
//            System.out.println(jsonObject);
//
//            webSocketTest.sendObject(jsonObject);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
}
