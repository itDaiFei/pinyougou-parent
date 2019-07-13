package com;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestValue {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue(){
         redisTemplate.boundValueOps("name").set("hello_world");

    }

    @Test
    public void getValue(){
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    @Test
    public void delete(){
        redisTemplate.delete("name");

    }

    @Test
    public void set(){
        redisTemplate.boundSetOps("setname").add("nihao");
        redisTemplate.boundSetOps("setname").add("wohao");
        redisTemplate.boundSetOps("setname").add("dajiahao");

    }

    @Test
    public void get(){
        Set setname = redisTemplate.boundSetOps("setname").members();
        System.out.println(setname);

    }




}
