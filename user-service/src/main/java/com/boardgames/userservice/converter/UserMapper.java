package com.boardgames.userservice.converter;

import com.boardgames.userservice.dto.UserDTO;
import com.boardgames.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User UserDTOToUser(UserDTO userDTO);

    UserDTO UserToUserDTO(User user);
}
