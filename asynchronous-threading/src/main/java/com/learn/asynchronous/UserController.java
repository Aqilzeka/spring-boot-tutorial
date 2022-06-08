package com.learn.asynchronous;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/info")
    public Object getUserInfo(@RequestParam Long userId) {
        long TomcatStart = System.currentTimeMillis();
        UserEntity userInfo = userService.getUserInfo(userId);

        System.out.println("Tomcat Thread(" + Thread.currentThread() + ")cost:" + (System.currentTimeMillis() - TomcatStart));

        return userInfo;
    }

    @RequestMapping("/info-async")
    public Callable<Object> getUserInfoAsync(@RequestParam Long userId) {
        long TomcatStart = System.currentTimeMillis();

        Callable<Object> callable = () -> {
            long ChildStart = System.currentTimeMillis();
            Object result = userService.getUserInfo(userId);
            System.out.println("Child Thread (" + Thread.currentThread() + ")cost:" + (System.currentTimeMillis() - ChildStart));
            return result;
        };

        System.out.println("Tomcat Thread(" + Thread.currentThread() + ")cost:" + (System.currentTimeMillis() - TomcatStart));
        return callable;
    }
}
