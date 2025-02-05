package com.resaSmile.ResaSmile.Mapper;

import com.resaSmile.ResaSmile.Models.User;
import com.resaSmile.ResaSmile.ModelsDTO.UserProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    @Mapping(target = "mot_de_passe", ignore = true)
    UserProfileDTO userToUserProfileDTO(User user);
}