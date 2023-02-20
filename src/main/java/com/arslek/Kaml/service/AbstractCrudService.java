package com.arslek.Kaml.service;

import com.arslek.Kaml.Entity.AbstractEntity;
import com.arslek.Kaml.mapper.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class AbstractCrudService<TYPE_ID, DTO, ENTITY extends AbstractEntity<TYPE_ID>, REPOSITORY extends JpaRepository<ENTITY, TYPE_ID>, MAPPER extends Mapper<DTO, ENTITY>> {
    private final REPOSITORY repository;
    private final MAPPER mapper;

    protected AbstractCrudService(REPOSITORY repository, MAPPER mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public DTO create(DTO dto) {
        ENTITY entity = this.mapper.destinationToSource(dto);
        entity = this.getRepository().save(entity);
        return this.mapper.sourceToDestination(entity);
    }

    @Transactional
    public DTO read(TYPE_ID id) {
        Optional<ENTITY> entity = this.getRepository().findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException(String.format("Entity with id: %s not found", id));
        }
        return this.getMapper().sourceToDestination(entity.get());
    }

    @Transactional
    public DTO update(TYPE_ID id, DTO dto) {
        ENTITY entity = this.getMapper().destinationToSource(dto);
        entity.setId(id);
        entity = this.getRepository().save(entity);
        return this.getMapper().sourceToDestination(entity);
    }

    @Transactional
    public void delete(TYPE_ID id) {
        this.getRepository().deleteById(id);
    }

    protected REPOSITORY getRepository() {
        return this.repository;
    }

    protected MAPPER getMapper() {
        return this.mapper;
    }
}
