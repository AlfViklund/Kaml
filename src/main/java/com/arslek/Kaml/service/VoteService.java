package com.arslek.Kaml.service;

import com.arslek.Kaml.Entity.VoteEntity;
import com.arslek.Kaml.dto.VoteDto;
import com.arslek.Kaml.mapper.VoteMapper;
import com.arslek.Kaml.repository.VoteRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VoteService extends AbstractCrudService<Long, VoteDto, VoteEntity, VoteRepository, VoteMapper> {


    protected VoteService(VoteRepository repository) {
        super(repository, Mappers.getMapper(VoteMapper.class));
    }

    public List<VoteDto> getTopQuote(Long quoteId) {
        List<VoteEntity> entites = this.getRepository().findByQuoteId(quoteId);
        ;
        return entites.stream()
                .map(e -> this.getMapper().sourceToDestination(e))
                .collect(Collectors.toList());
    }

    public Map<String, List<VoteDto>> getVoteGraph(Long quoteId) {
        Map<String, List<VoteDto>> graph = new HashMap<>();
        VoteMapper voteMapper = this.getMapper();
        List<VoteEntity> entities = this.getRepository().findByQuoteId(quoteId).stream()
                .sorted(Comparator.comparing(e -> e.getUpdateDate().getDay())).toList();
        for (VoteEntity entity : entities) {
            String day = String.valueOf(entity.getUpdateDate().getDay());
            if (graph.containsKey(day)) {
                graph.get(day).add(voteMapper.sourceToDestination(entity));
            } else {
                List<VoteDto> list = new ArrayList<>();
                list.add(voteMapper.sourceToDestination(entity));
                graph.put(day, list);
            }
        }
        return graph;
    }
}
