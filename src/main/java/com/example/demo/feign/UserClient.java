package com.example.demo.feign;

import com.example.demo.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userClient", url = "https://reqres.in")
public interface UserClient {

    @GetMapping("/api/users/{id}")
    public User getUser(@PathVariable("id") int id);

}
