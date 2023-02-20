package com.arslek.Kaml.mapper;

public interface Mapper<DTO, ENTITY> {

    ENTITY destinationToSource(DTO dto);

    DTO sourceToDestination(ENTITY entity);
}
