package ch.puzzle.workshop.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieQuoteController {
    @RequestMapping("/quote")
    public List<String> getQuotes() {
        return Arrays.asList("May the force be with you", "I am your father");
    }

}
