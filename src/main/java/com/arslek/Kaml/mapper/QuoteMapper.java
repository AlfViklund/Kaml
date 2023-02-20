package com.arslek.Kaml.mapper;

import com.arslek.Kaml.Entity.QuoteEntity;
import com.arslek.Kaml.Entity.UserEntity;
import com.arslek.Kaml.dto.QuoteDto;
import com.arslek.Kaml.dto.UserDto;

@org.mapstruct.Mapper(componentModel = "spring")
public interface QuoteMapper extends Mapper<QuoteDto, QuoteEntity> {
}
