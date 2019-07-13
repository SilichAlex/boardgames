package com.boardgames.userservice.controller;

import com.boardgames.userservice.dto.UserDTO;
import com.boardgames.userservice.service.RegisterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final RegisterService registerService;

    public UserController(RegisterService registerService) {
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

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        registerService.deleteUserById(userId);
    }


}
