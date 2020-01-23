package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.Book;
import org.javaboy.vhr.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-09-21 21:15
 */
@RestController
public class LoginController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录!");
    }


    @GetMapping("/testRedis")
    public void testRedis() {
        ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("lol", "test for my website");
        String name = ops1.get("lol");
        System.out.println("-get name from redis--->" + name);

        Book book = new Book("LOL 三部曲", "Jeremy", 99.99f);
        ValueOperations ops2 = redisTemplate.opsForValue();
        ops2.set("bb", book);

        Book bb = (Book) ops2.get("bb");
        System.out.println(bb);
    }
}
