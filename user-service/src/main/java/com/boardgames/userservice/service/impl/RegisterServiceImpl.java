package com.boardgames.userservice.service.impl;

import com.boardgames.userservice.converter.UserMapper;
import com.boardgames.userservice.dao.UserDAO;
import com.boardgames.userservice.dto.UserDTO;
import com.boardgames.userservice.entity.User;
import com.boardgames.userservice.exception.NotFoundException;
import com.boardgames.userservice.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
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
        user.setActive(true);
        log.info("User with username {} has been created", user.getUsername());
        return userMapper.UserToUserDTO(userDAO.save(user));
    }

    @Override
    @Transactional
    public UserDTO deleteUserById(Integer userId) {
        Optional<User> userOpt = userDAO.findById(userId);
        return userOpt.map(user -> {
            user.setActive(false);
            userDAO.save(user);
            return userMapper.UserToUserDTO(user);
        }).orElseThrow(() -> new NotFoundException(userId.toString()));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO findUserById(Integer userId) {
        return userDAO.findByIdAndActiveTrue(userId).map(userMapper::UserToUserDTO)
                .orElseThrow(() -> new NotFoundException("USER with id " + userId.toString() + " not found"));
    }
}
