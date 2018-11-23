package com.school.utils;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;

/**
 * Created by 梁栩菖
 * 2018/11/5 17:02
 */
public class BaiduBOSUtil {

    public void one(){
        String ACCESS_KEY_ID = "c84414832e9e40d39fd60dfc43e0774b";                   // 用户的Access Key ID
        String SECRET_ACCESS_KEY = "52f103a999ff4df7885b1e86e1dbd94a";           // 用户的Secret Access Key

        // 初始化一个BosClient
        BosClientConfiguration config = new BosClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY));
        BosClient client = new BosClient(config);
    }

}
