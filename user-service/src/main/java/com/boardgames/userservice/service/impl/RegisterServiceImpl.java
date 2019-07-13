package com.boardgames.userservice.service.impl;

import com.boardgames.userservice.converter.UserMapper;
import com.boardgames.userservice.dao.UserDAO;
import com.boardgames.userservice.dto.UserDTO;
import com.boardgames.userservice.entity.User;
import com.boardgames.userservice.exception.NotFoundException;
import com.boardgames.userservice.service.RegisterService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {


    private final UserMapper userMapper;
    private final UserDAO userDAO;

    public RegisterServiceImpl(UserMapper userMapper, UserDAO userDAO) {
        this.userMapper = userMapper;
        this.userDAO = userDAO;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.UserDTOToUser(userDTO);
        return userMapper.UserToUserDTO(userDAO.save(user));
    }

    @Override
    public UserDTO deleteUserById(Integer userId) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO findUserById(Integer userId) {
        return userDAO.findById(userId).map(userMapper::UserToUserDTO)
                .orElseThrow(() -> new NotFoundException(userId.toString()));
    }
}
