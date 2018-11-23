package com.school.controller;

import com.school.dataobject.Result;
import com.school.dataobject.User;
import com.school.service.UserService;
import com.school.utils.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by 梁栩菖
 * 2018/11/1 18:52
 */
@CrossOrigin
@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value="/classroom/idcard", method = RequestMethod.POST)
//    public @ResponseBody
//    Result<User> uploadImg(@RequestParam("file") MultipartFile file, String phone, String openid, String avatarUrl, String nickname,int userId) {
//        String contentType = file.getContentType();
//        String fileName = file.getOriginalFilename();
//        System.out.println(contentType);
//        System.out.println(fileName);
//        try {
//            System.out.println(file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("错误");
//        }
//        String filePath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
//        System.out.println(filePath);
//        try {
//            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
//            System.out.println("文件上传成功");
//            //            ------------------------身份证识别-------------------------------
//            String dizhi = filePath+fileName;
//            JSONObject json1 = idcard(dizhi);
//
//            JSONObject json = json1.getJSONObject("words_result");
//
//            JSONObject j1 = json.getJSONObject("公民身份号码");
//            String cardid = j1.getString( "words");
//
//            JSONObject j2 = json.getJSONObject("姓名");
//            String name = j2.getString("words");
//
//            JSONObject j3 = json.getJSONObject("住址");
//            String address = j3.getString("words");
//
//            JSONObject j4 = json.getJSONObject("出生");
//            String birth = j4.getString("words");
//
//            JSONObject j5 = json.getJSONObject("性别");
//            String sex = j5.getString("words");
//
//            JSONObject j6 = json.getJSONObject("民族");
//            String national = j6.getString("words");
//
//            User user = new User();
//            user.setUserId(userId);
//            user.setSex(sex);
//            user.setPhone(phone);
//            user.setName(name);
//            user.setAvatarUrl(avatarUrl);
//            user.setNickName(nickname);
//            user.setOpenId(openid);
//            user.setAddress(address);
//            user.setBirth(birth);
//            user.setId(cardid);
//            user.setNational(national);
//
////            userService.updateOne(sex,openid,address,avatarUrl,birth,cardid,name,national,nickname,phone);
////            return ResultUtil.error(0,"注册成功");
//            return ResultUtil.success(userRepository.save(user));
//
//        } catch (Exception e) {
//            // TODO: handle exception
////            System.out.println(e.getMessage());
//            e.printStackTrace();
//            return ResultUtil.error(1,"注册失败");
//        }
//    }

    /**
     * 教师
     * 微信小程序完善身份信息
     * @param request
     * @param phone
     * @param openid
     * @param avatarUrl
     * @param nickname
     * @param userId
     * @return
     */
    @RequestMapping(value="/classroom/user/idcard", method = RequestMethod.POST)
    public Result<User> uploadPicture(HttpServletRequest request,String phone,String openid, String avatarUrl, String nickname,int userId){
        return ResultUtil.success(userService.updateUser(request,phone,openid,avatarUrl,nickname,userId));

    }



//    @RequestMapping("/picture")
//    public void uploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        //获取文件需要上传到的路径
//        String path = request.getRealPath("/upload") + "/";
//        File dir = new File(path);
//        if (!dir.exists()) {
//            dir.mkdir();
//        }
////        logger.debug("path=" + path);
//
//        request.setCharacterEncoding("utf-8");  //设置编码
//        //获得磁盘文件条目工厂
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//
//        //如果没以下两行设置的话,上传大的文件会占用很多内存，
//        //设置暂时存放的存储室,这个存储室可以和最终存储文件的目录不同
//        /**
//         * 原理: 它是先存到暂时存储室，然后再真正写到对应目录的硬盘上，
//         * 按理来说当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
//         * 然后再将其真正写到对应目录的硬盘上
//         */
//        factory.setRepository(dir);
//        //设置缓存的大小，当上传文件的容量超过该缓存时，直接放到暂时存储室
//        factory.setSizeThreshold(1024 * 1024);
//        //高水平的API文件上传处理
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        try {
//            List<FileItem> list = upload.parseRequest(request);
//            FileItem picture = null;
//            for (FileItem item : list) {
//                //获取表单的属性名字
//                String name = item.getFieldName();
//                //如果获取的表单信息是普通的 文本 信息
//                if (item.isFormField()) {
//                    //获取用户具体输入的字符串
//                    String value = item.getString();
//                    request.setAttribute(name, value);
////                    logger.debug("name=" + name + ",value=" + value);
//                } else {
//                    picture = item;
//                }
//            }
//
//            //自定义上传图片的名字为userId.jpg
//            String fileName = request.getAttribute("userId") + ".jpg";
//            String destPath = path + fileName;
////            logger.debug("destPath=" + destPath);
//
//            //真正写到磁盘上
//            File file = new File(destPath);
//            OutputStream out = new FileOutputStream(file);
//            InputStream in = picture.getInputStream();
//            int length = 0;
//            byte[] buf = new byte[1024];
//            // in.read(buf) 每次读到的数据存放在buf 数组中
//            while ((length = in.read(buf)) != -1) {
//                //在buf数组中取出数据写到（输出流）磁盘上
//                out.write(buf, 0, length);
//            }
//            in.close();
//            out.close();
//        } catch (FileUploadException e1) {
//            logger.error("", e1);
//        } catch (Exception e) {
//            logger.error("", e);
//        }
//
//
//        PrintWriter printWriter = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");
//        HashMap<String, Object> res = new HashMap<String, Object>();
//        res.put("success", true);
//        printWriter.write(JSON.toJSONString(res));
//        printWriter.flush();
//    }

//    @RequestMapping(value="/classroom/test", method = RequestMethod.GET)
//    public @ResponseBody
//    Result<User> test(int userId,String phone, String openid, String avatarUrl, String nickname,String sex,String address,String birth,String cardid,String name,String national) {
//        try {
//            userService.updateOne(sex,openid,address,avatarUrl,birth,cardid,name,national,nickname,phone);
//            User user = new User();
//            user.setUserId(userId);
//            user.setSex(sex);
//            user.setPhone(phone);
//            user.setName(name);
//            user.setAvatarUrl(avatarUrl);
//            user.setNickName(nickname);
//            user.setOpenId(openid);
//            user.setAddress(address);
//            user.setBirth(birth);
//            user.setId(cardid);
//            user.setNational(national);
//            userRepository.updateOne(address,openid,avatarUrl,birth,cardid,name,national,nickname,phone,sex,userId);
//            return ResultUtil.success(userRepository.save(user));
//            return ResultUtil.error(0,"注册成功");
//            return ResultUtil.error(0,"注册成功");
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//            return ResultUtil.error(1,"注册失败");
//        }
//    }
}
