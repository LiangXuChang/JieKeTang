package com.school.service;

import com.school.dataobject.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 梁栩菖
 * 2018/11/2 10:13
 */
public interface UserService {

    //创建用户
    public User addUser(User user);

    //查询用户
    public User selectUser(String openid);

    //完善用户信息
    public User updateUser(HttpServletRequest request,String phone,String openid, String avatarUrl, String nickname,int userId);

//    @Query(value = "update Studnet set sex=?1,address=?3,avatar_url=?4,birth=?5,id=?6,name=?7,national=?8,nick_name=?9,phone=?10 where open_id=?2 ", nativeQuery = true)
//    @Modifying
//    public void updateOne(String sex,String open_id,String address,String avatar_url, String birth ,String id ,String name ,String national, String nick_name, String phone);
}
