package com.school.controller;

import com.google.gson.Gson;
import com.school.dataobject.Doc;
import com.school.dataobject.Result;
import com.school.service.DocService;
import com.school.utils.FileUtil;
import com.school.utils.HttpUtil;
import com.school.utils.PDFTemplateUtil;
import com.school.utils.ResultUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
public class UploadingController {
    //跳转到上传文件的页面
//    @GetMapping(value="/gouploadimg")
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
//        response.sendRedirect(E:/workspace/school/src/main/resources/templates/uploading.html);
        return "uploading";
    }

//    private static String uoloadPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "upload/";
    @Autowired
    private DocService docService;

    //处理文件上传
    @RequestMapping(value="/classroom/uploadimg", method = RequestMethod.POST)
    public @ResponseBody
    Result<Doc> uploadImg(@RequestParam("file") MultipartFile file, String id) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println(contentType);
        System.out.println(fileName);
        try {
            System.out.println(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("错误");
        }
        String filePath = "C:\\apache-tomcat-8.5.20\\webapps\\img\\";
        System.out.println(filePath);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            System.out.println("文件上传成功");
//            ------------------------生成word文档-------------------------------
            // 要填充的数据, 注意map的key要和word中${xxx}的xxx一致
            try {
                String dizhi = filePath+fileName;
                String test = font(dizhi);

                Map<String, Object> dataMap = new HashMap<String, Object>();
                JSONObject j = JSONObject.fromObject(test);

                System.out.println("一号输出:"+j);

                String c = j.getString("words_result");

                JSONArray jsonArray = JSONArray.fromObject(c);

                for(int i=0;i<jsonArray.size();i++){
                    JSONObject j1 = JSONObject.fromObject(jsonArray.get(i));

                    dataMap.put("text"+i, j1.getString("words"));
                }

//                System.out.println("二号输出:"+c);
//
//                String a = c.substring(1,c.length()-1);
//
//                System.out.println("三号输出:"+a);
//                JSONObject b = JSONObject.fromObject(a);
//
//                System.out.println("四号输出:"+b);
//                dataMap.put("username", b.getString("words"));

                //Configuration用于读取ftl文件
                Configuration configuration = new Configuration();
                configuration.setDefaultEncoding("utf-8");

                //指定路径的第二种方式,我的路径是C:/a.ftl
                configuration.setDirectoryForTemplateLoading(new File("C:\\apache-tomcat-8.5.20\\webapps\\img\\"));

                String pathname = "C:\\apache-tomcat-8.5.20\\webapps\\img\\"+fileName.substring(0,fileName.length()-5)+".doc";

                String url = "test.socialcontactblog.com/img/"+fileName.substring(0,fileName.length()-5)+".doc";

                //将doc文档url存入数据库
                Doc doc = new Doc();
                doc.setCId(id);
                doc.setDocUrl(url);

                //生成pdf文档
                FileOutputStream out1 = new FileOutputStream(new File("C:\\apache-tomcat-8.5.20\\webapps\\img\\"+fileName.substring(0,fileName.length()-5)+".pdf"));

                PDFTemplateUtil pdfUtil = new PDFTemplateUtil();
                pdfUtil.createPDF(dataMap, out1);


                // 输出文档路径及名称
                File outFile = new File(pathname);

                //以utf-8的编码读取ftl文件
                Template t =  configuration.getTemplate("user.ftl.xml","utf-8");
                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
                t.process(dataMap, out);
                out.close();
                Gson gson = new Gson();

                System.out.println(gson.toJson(pathname));

                return ResultUtil.success(docService.saveDoc(doc));
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("结束");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        //返回json

        return ResultUtil.error(1,"获取url失败");
    }

    /**
     * 文字识别方法
     * @param filepath
     * @return
     */
    public static String font(String filepath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/handwriting";
        try {
            // 本地文件路径
            byte[] imgData = Util.readFileByBytes(filepath);

            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.a1eb042f6a70d2902843e090cc63fadb.2592000.1542012795.282335-14388230";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件下载
     * @param request
     * @param response
     * @return
     */
//    @RequestMapping(value = "/download", method = RequestMethod.GET)
//    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
//        String fileName = "1-1  课程介绍.wmv";// 设置文件名，根据业务需要替换成要下载的文件名
//        if (fileName != null) {
//            //设置文件路径
//            String realPath = "C:\\img\\";
//            File file = new File(realPath , fileName);
//            if (file.exists()) {
//                response.setContentType("application/force-download");// 设置强制下载不打开
//                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
//                byte[] buffer = new byte[1024];
//                FileInputStream fis = null;
//                BufferedInputStream bis = null;
//                try {
//                    fis = new FileInputStream(file);
//                    bis = new BufferedInputStream(fis);
//                    OutputStream os = response.getOutputStream();
//                    int i = bis.read(buffer);
//                    while (i != -1) {
//                        os.write(buffer, 0, i);
//                        i = bis.read(buffer);
//                    }
//                    System.out.println("success");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    if (bis != null) {
//                        try {
//                            bis.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if (fis != null) {
//                        try {
//                            fis.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }

//    /**
//     * 微信小程序文件上传
//     * @param request
//     * @throws Exception
//     */
//    @RequestMapping(value="/picture", method = RequestMethod.POST)
//    public void uploadPicture(HttpServletRequest request) throws Exception {
//        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
//        MultipartFile multipartFile =  req.getFile("file");
//
//        String realPath = "D:\\image\\";
//        try {
//            File dir = new File(realPath);
//            if (!dir.exists()) {
//                dir.mkdir();
//            }
//            File file  =  new File(realPath,"aaa.jpg");
//            System.out.println(file);
//            multipartFile.transferTo(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }
//
//    }

}