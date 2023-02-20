package com.arslek.Kaml.service;

import com.arslek.Kaml.Entity.QuoteEntity;
import com.arslek.Kaml.Entity.UserEntity;
import com.arslek.Kaml.dto.QuoteDto;
import com.arslek.Kaml.dto.UserDto;
import com.arslek.Kaml.mapper.QuoteMapper;
import com.arslek.Kaml.mapper.UserMapper;
import com.arslek.Kaml.repository.QuoteRepository;
import com.arslek.Kaml.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuoteService  extends AbstractCrudService<Long, QuoteDto, QuoteEntity, QuoteRepository, QuoteMapper>  {
    protected QuoteService(QuoteRepository repository) {
        super(repository, Mappers.getMapper(QuoteMapper.class));
    }

//    public List<QuoteDto> getTop(Long count) {
//        List<QuoteEntity> entities = super.getRepository().findTop(count);
//        return entities.stream()
//                .map(e -> super.getMapper().sourceToDestination(e))
//                .collect(Collectors.toList());
//    }
}
