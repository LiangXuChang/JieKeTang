package com.school.repository;

import com.school.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by 梁栩菖
 * 2018/11/2 10:17
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByopenId(String openid);

//    @Query(value = "update Studnet set address=?1,avatar_url=?3,birth=?4,id=?5,name=?6,national=?7,nick_name=?8,phone=?9,sex=?10,open_id=?2 where user_id=?11 ", nativeQuery = true)
//    @Modifying
//    public void updateOne(String address,String open_id,String avatar_url,String birth,String id,String name,String national,String nick_name,String phone,String sex,int user_id);
}
