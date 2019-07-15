package com.example.demo.service;

import com.example.demo.config.ExecutorConfig;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   /* @Autowired
    private UserMapper userMapper;
*/
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Async("asyncServiceExecutor")
    public void selectUser() {
        logger.info("statar selectUser");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Async("asyncServiceExecutor")
    public void doTaskOne() throws Exception {
        logger.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        logger.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async("asyncServiceExecutor")
    public void doTaskTwo() throws Exception {
        logger.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        logger.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async("asyncServiceExecutor")
    public void doTaskThree() throws Exception {
        logger.info("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        logger.info("完成任务三，耗时：" + (end - start) + "毫秒");
    }
    @Async
    public void setUser() {
        for (int i = 0;i <10;i++){
            System.out.println(i);
        }
    }

    /*public List selectList(List<User> list) {
        return userMapper.selectList(list);
    }

    public String selectOne(String s) {
        return  userMapper.selectOne(s);
    }*/
}
