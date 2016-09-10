package ch.puzzle.workshop.springboot.controller;

import ch.puzzle.workshop.springboot.model.MovieQuote;
import ch.puzzle.workshop.springboot.repository.MovieQuoteRepository;
import ch.puzzle.workshop.springboot.util.Piratetifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
public class MovieQuoteController {

    protected Piratetifier piratetifier;
    protected MovieQuoteRepository repository;

    @Autowired
    public MovieQuoteController(Piratetifier piratetifier, MovieQuoteRepository repository) {
        this.piratetifier = piratetifier;
        this.repository = repository;
    }

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("MovieQuotes.json");
        List<MovieQuote> list = mapper.readValue(resource.getInputStream(), mapper.getTypeFactory().constructCollectionType(List.class, MovieQuote.class));
        repository.save(list);
    }

    @RequestMapping("/quote")
    public Iterable<MovieQuote> getQuotes() {
        return repository.findAll();
    }

    @RequestMapping("/piratequote")
    public Iterable<MovieQuote> getPirateQuotes() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(quote -> {
                    quote.setQuote(piratetifier.piratetify(quote.getQuote()));
                    return quote;
                }).collect(Collectors.toList());
    }

}
