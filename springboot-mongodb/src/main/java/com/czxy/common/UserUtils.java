package com.czxy.common;

import org.springframework.data.mongodb.core.query.Update;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author 郭德峻
 * @create 2018/9/18 11:49
 * @mailbox guodejun0808@163.com
 * @desc
 **/
public class UserUtils {
    /**
     * @author 郭德峻
     * @create 2018/9/9 2:11
     * @desc 该方法用于拼接更新数据
     * 参数：javaBean
     * 返回值：Updata
     **/
    public static Update UpdateUtils(Object obj) {
        try {
            Update update = new Update();
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Method read = pd.getReadMethod();
                Object invoke = read.invoke(obj, new Object[0]);
                if (invoke != null) {
                    update.set(pd.getName(), invoke);
                }
            }
            return update;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
