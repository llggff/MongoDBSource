package com.czxy.service;

import com.czxy.pojo.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.czxy.common.UserUtils.UpdateUtils;

/**
 * @author 郭德峻
 * @create 2018/9/6 8:54
 * @mailbox guodejun0808@163.com
 * @desc
 **/
@Component
public class UserService {


    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 添加 user
     * @param user
     */
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("name").is(userName));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    /**
     * 更新对象
     * @param user
     */
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        /*调用UpdateUtils 数据拼接*/
        Update update = UpdateUtils(user);
        //更新查询返回结果集的第一条
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
        System.err.println(updateResult);
    }


    /**
     * @desc id查一个
     **/
    public User findById(String id) {
        User user = mongoTemplate.findById(id, User.class);
        return user;
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteUserById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        //删除的对象
        User c = mongoTemplate.findAndRemove(query, User.class);
    }

    /**
     * @desc 查询 多条 数据
     * 注：页码在 mongodb 中是从0开始的。
     **/
    public List<User> findByCondition() {
        List<User> list = mongoTemplate.findAll(User.class);
        return list;
    }


    public void save(User user) {
        mongoTemplate.save(user);
    }


}
