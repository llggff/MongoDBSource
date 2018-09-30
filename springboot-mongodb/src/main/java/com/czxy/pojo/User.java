package com.czxy.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 郭德峻
 * @create 2018/9/5 10:30
 * @mailbox 1608986484@qq.com
 * @desc
 **/
@Document(collection = "user")
public class User implements Serializable {

    private String id;
    private String name;
    private String sex;
    private Integer age;
    private String phone;

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(String id, String name, String sex, Integer age, String phone) {

        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
