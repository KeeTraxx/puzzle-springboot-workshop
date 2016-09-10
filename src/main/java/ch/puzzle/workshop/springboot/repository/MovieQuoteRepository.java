package ch.puzzle.workshop.springboot.repository;

import ch.puzzle.workshop.springboot.model.MovieQuote;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieQuoteRepository extends PagingAndSortingRepository<MovieQuote,Long> {
    
}