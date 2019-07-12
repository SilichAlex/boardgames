package com.boardgames.userservice.controller;

import com.boardgames.userservice.dto.UserDTO;
import com.boardgames.userservice.service.RegisterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable Integer userId){
        return registerService.findUserById(userId);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return registerService.createUser(userDTO);
    }

    @PutMapping("/{userId}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable Integer userId){
        return registerService.updateUser(userDTO);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Integer userId){
        registerService.deleteUserById(userId);
    }


}
