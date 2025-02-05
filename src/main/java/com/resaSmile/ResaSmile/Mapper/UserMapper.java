package com.resaSmile.ResaSmile.Mapper;

import com.resaSmile.ResaSmile.Models.User;
import com.resaSmile.ResaSmile.ModelsDTO.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
}