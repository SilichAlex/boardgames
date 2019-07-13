package com.boardgames.userservice.service;

import com.boardgames.userservice.dto.UserDTO;

public interface RegisterService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO deleteUserById(Integer userId);

    UserDTO updateUser(UserDTO userDTO);

    UserDTO findUserById(Integer userId);
}
