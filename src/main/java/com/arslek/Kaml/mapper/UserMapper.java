package com.arslek.Kaml.mapper;

import com.arslek.Kaml.Entity.UserEntity;
import com.arslek.Kaml.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@org.mapstruct.Mapper(componentModel = "spring")
public interface UserMapper extends Mapper<UserDto, UserEntity> {
}
