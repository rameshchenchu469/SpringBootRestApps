package com.nt.utility;

import org.mapstruct.factory.Mappers;

import com.nt.dto.UserDTO;
import com.nt.entity.UserEntity;

public interface UserMapper {

	UserMapper   INSTANCE= Mappers.getMapper(UserMapper.class);


	  UserEntity dtoToEntity(UserDTO userDto);

	  UserDTO entityToDto(UserEntity entity);
}
