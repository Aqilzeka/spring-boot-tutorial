package com.learn.asynchronous;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class UserService {
    public UserEntity getUserInfo(Long userId) {
        List<UserEntity> users = Arrays.asList(
                new UserEntity(1L, "Aqil", "12345"),
                new UserEntity(2L, "Ali", "12345"),
                new UserEntity(3L, "Aysu", "12345"),
                new UserEntity(4L, "Lale", "12345")
        );

        return users
                .stream()
                .filter(userEntity ->
                        Objects.equals(userEntity.getId(), userId))
                .findFirst().orElse(null);
    }
}
