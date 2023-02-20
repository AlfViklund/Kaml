package com.arslek.Kaml.controller;

import com.arslek.Kaml.dto.QuoteDto;
import com.arslek.Kaml.dto.UserDto;
import com.arslek.Kaml.dto.VoteDto;
import com.arslek.Kaml.service.VoteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("crud")
public class VoteController {

    private final VoteService service;

    public VoteController(VoteService service) {
        this.service = service;
    }

    @GetMapping("vote/top/quote/{id}")
    public List<VoteDto> getTopQuote(@PathVariable Long id) {
        return service.getTopQuote(id);
    }

    @GetMapping("vote/evolution/quote/{id}")
    public Map<String, List<VoteDto>> getEvolution(@PathVariable Long id) {
        return service.getVoteGraph(id);
    }

    @PostMapping("vote")
    public VoteDto upsert(@RequestBody VoteDto dto) {
        return service.create(dto);
    }

    @GetMapping("vote/{id}")
    public VoteDto read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("vote/{id}")
    public VoteDto update(@PathVariable Long id, @RequestBody VoteDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("vote/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
