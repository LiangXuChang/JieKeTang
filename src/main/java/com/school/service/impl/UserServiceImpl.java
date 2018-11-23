package com.school.service.impl;

import com.baidu.aip.ocr.AipOcr;
import com.school.dataobject.User;
import com.school.repository.UserRepository;
import com.school.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 梁栩菖
 * 2018/11/2 10:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //教师注册
    public User addUser(User user){
        user.setOpenId(user.getOpenId());
        user.setNickName(user.getNickName());
        user.setAvatarUrl(user.getAvatarUrl());
        return userRepository.save(user);
    }

    //教师查询
    public User selectUser(String openid){
        return userRepository.findByopenId(openid);
    }

    //教师在小程序中完善身份信息
    public User updateUser(HttpServletRequest request, String phone, String openid, String avatarUrl, String nickname, int userId){
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("file");
        String fileName = multipartFile.getOriginalFilename();
        String realPath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file  =  new File(realPath,"aaa.jpg");
            System.out.println(file);
            multipartFile.transferTo(file);

            String dizhi = realPath+fileName;
            JSONObject json1 = idcard(dizhi);

            JSONObject json = json1.getJSONObject("words_result");

            JSONObject j1 = json.getJSONObject("公民身份号码");
            String cardid = j1.getString( "words");

            JSONObject j2 = json.getJSONObject("姓名");
            String name = j2.getString("words");

            JSONObject j3 = json.getJSONObject("住址");
            String address = j3.getString("words");

            JSONObject j4 = json.getJSONObject("出生");
            String birth = j4.getString("words");

            JSONObject j5 = json.getJSONObject("性别");
            String sex = j5.getString("words");

            JSONObject j6 = json.getJSONObject("民族");
            String national = j6.getString("words");

            User user = new User();
            user.setUserId(userId);
            user.setSex(sex);
            user.setPhone(phone);
            user.setName(name);
            user.setAvatarUrl(avatarUrl);
            user.setNickName(nickname);
            user.setOpenId(openid);
            user.setAddress(address);
            user.setBirth(birth);
            user.setId(cardid);
            user.setNational(national);

//            userService.updateOne(sex,openid,address,avatarUrl,birth,cardid,name,national,nickname,phone);
//            return ResultUtil.error(0,"注册成功");
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject idcard(String filepath) {

        String APP_ID = "14388230";
        String API_KEY = "eqGEeE5Bcxe5uzX55ubpf6m8";
        String SECRET_KEY = "er63URbSGi1SwyiGYlLccKMqtYUkWdjh";

        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);



        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");
        String idCardSide = "front";

        String image = filepath;
        JSONObject res = client.idcard(image, idCardSide, options);
        System.out.println(res);
        return res;

    }
}
