package com.czxy.controller;

import com.czxy.pojo.User;
import com.czxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 郭德峻
 * @create 2018/9/5 11:48
 * @mailbox guodejun0808@163.com
 * @desc
 **/
@RestController
@RequestMapping("/userOperation")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @author 郭德峻
     * @create 2018/9/5 10:55
     * @desc 查询所有用户 访问路径 /userOperation/selectAll
     **/
    @GetMapping("/selectAll")
    public ResponseEntity<List<User>> findAll() {
        try {
            List<User> result = userService.findByCondition();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @author 郭德峻
     * @create 2018/9/5 10:56
     * @desc 根据id 进行单个查询 访问路径 /userOperation/id
     **/
    @GetMapping("/{id}")
    public ResponseEntity<User> findByCondition(@PathVariable("id") String id) {
        try {
            User user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @author 郭德峻
     * @create 2018/9/5 10:55
     * @desc 添加用户
     **/
    @PostMapping
    public ResponseEntity<Void> addStandard(User user) {
        try {
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @author 郭德峻
     * @create 2018/9/5 10:55
     * @desc 删除用户
     **/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        try {
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @author 郭德峻
     * @create 2018/9/5 10:56
     * @desc 修改用户
     **/
    @PutMapping
    public ResponseEntity<Void> editUser(User user) {
        try {
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
