package ch.puzzle.workshop.springboot.controller;

import ch.puzzle.workshop.springboot.util.Piratetifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MovieQuoteController {

    protected Piratetifier piratetifier;

    @Autowired
    public MovieQuoteController(Piratetifier piratetifier) {
        this.piratetifier = piratetifier;
    }

    @RequestMapping("/quote")
    public List<String> getQuotes() {
        return Arrays.asList("May the force be with you", "I am your father");
    }

    @RequestMapping("/piratequote")
    public List<String> getPirateQuotes() {
        return Arrays.asList("May the force be with you", "I am your father").stream().map(quote -> piratetifier.piratetify(quote)).collect(Collectors.toList());
    }

}
