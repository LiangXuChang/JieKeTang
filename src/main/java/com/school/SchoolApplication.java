package com.school;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.PutObjectResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootApplication
@EnableCaching
public class SchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
//            String ACCESS_KEY_ID = "c84414832e9e40d39fd60dfc43e0774b";                   // 用户的Access Key ID
//            String SECRET_ACCESS_KEY = "52f103a999ff4df7885b1e86e1dbd94a";           // 用户的Secret Access Key
//
//            // 初始化一个BosClient
//            BosClientConfiguration config = new BosClientConfiguration();
//            config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY));
//            config.setEndpoint("gz.bcebos.com");
//        BosClient client = new BosClient(config);
//            File file = new File("C:\\Users\\hasee\\Desktop\\WeChat_20180918172854.mp4");
////            try {
////                InputStream inputStream = new FileInputStream("C:\\Users\\hasee\\Desktop\\WeChat_20180918172854.mp4");
////            }catch (Exception e){
////                e.printStackTrace();
////            }
//            String bucketName = "classroom1";
//            String objectKey = "test";
//
//        PutObjectResponse putObjectFromFileResponse = client.putObject(bucketName, objectKey, file);
//        System.out.println(putObjectFromFileResponse.getETag());


    }
}
