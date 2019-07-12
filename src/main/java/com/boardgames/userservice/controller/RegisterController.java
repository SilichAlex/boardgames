package com.boardgames.userservice.controller;

import com.boardgames.userservice.dto.UserDTO;
import com.boardgames.userservice.service.RegisterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return registerService.createUser(userDTO);
    }


}
