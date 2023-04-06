package com.example.demo.resource;

import com.example.demo.feign.UserClient;
import com.example.demo.model.SampleHello;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserClient userClient;

    @GetMapping("/hello/{id}")
    public SampleHello hello(@PathVariable("id") int id) {

        User user = userClient.getUser(id);

        return SampleHello.builder()
                .hello("Hello World")
                .name(user.getData().getFirst_name())
                .build();
    }

}
