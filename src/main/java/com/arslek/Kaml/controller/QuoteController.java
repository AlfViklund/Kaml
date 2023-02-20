package com.arslek.Kaml.controller;

import com.arslek.Kaml.dto.QuoteDto;
import com.arslek.Kaml.dto.UserDto;
import com.arslek.Kaml.service.QuoteService;
import com.arslek.Kaml.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crud")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping("quote")
    public QuoteDto upsert(@RequestBody QuoteDto dto) {
        return quoteService.create(dto);
    }

    @GetMapping("quote/{id}")
    public QuoteDto read(@PathVariable Long id) {
        return quoteService.read(id);
    }

    @PutMapping("quote/{id}")
    public QuoteDto update(@PathVariable Long id, @RequestBody QuoteDto dto) {
        return quoteService.update(id, dto);
    }

    @DeleteMapping("quote/{id}")
    public void delete(@PathVariable Long id) {
        quoteService.delete(id);
    }
}
