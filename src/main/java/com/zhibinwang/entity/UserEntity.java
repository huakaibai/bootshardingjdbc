package com.zhibinwang.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 花开
 * @create 2019-09-21 12:36
 * @desc
 **/
@Entity
@Table(name ="t_user")
public class UserEntity {

    @Id
    private Long userId;
    private String userName;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
