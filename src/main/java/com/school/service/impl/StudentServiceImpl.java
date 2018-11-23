package com.school.service.impl;

import com.baidu.aip.ocr.AipOcr;
import com.school.dataobject.Student;
import com.school.repository.StudentRepository;
import com.school.service.StudentService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.HashMap;

/**
 * Created by 梁栩菖
 * 2018/11/7 15:48
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //创建学生
    public Student addStudent(Student student){
        student.setAvatarUrl(student.getAvatarUrl());
        student.setNickName(student.getNickName());
        student.setOpenId(student.getOpenId());
        return studentRepository.save(student);
    }

    //查询学生
    public Student selectStudent(String openid){
        return studentRepository.findByopenId(openid);
    }

    //学生在小程序中完善身份信息
    public Student updateStudent(HttpServletRequest request, String phone, String openid, String avatarUrl, String nickname, int studentId){
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

            Student student = new Student();
            student.setStudentId(studentId);
            student.setSex(sex);
            student.setPhone(phone);
            student.setName(name);
            student.setAvatarUrl(avatarUrl);
            student.setNickName(nickname);
            student.setOpenId(openid);
            student.setAddress(address);
            student.setBirth(birth);
            student.setId(cardid);
            student.setNational(national);

//            userService.updateOne(sex,openid,address,avatarUrl,birth,cardid,name,national,nickname,phone);
//            return ResultUtil.error(0,"注册成功");
            return studentRepository.save(student);
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
