package com.arslek.Kaml.service;

import com.arslek.Kaml.Entity.UserEntity;
import com.arslek.Kaml.dto.UserDto;
import com.arslek.Kaml.mapper.QuoteMapper;
import com.arslek.Kaml.mapper.UserMapper;
import com.arslek.Kaml.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<Long, UserDto, UserEntity, UserRepository, UserMapper> {
    protected UserService(UserRepository repository) {
        super(repository, Mappers.getMapper(UserMapper.class));
    }

    @Autowired
    private UserRepository repo;

    @Override
    public UserDto read(Long aLong) {
        UserMapper map = Mappers.getMapper(UserMapper.class);
        return map.sourceToDestination(repo.findById(aLong).get());
    }
}
