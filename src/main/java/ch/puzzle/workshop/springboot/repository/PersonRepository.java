package ch.puzzle.workshop.springboot.repository;

import ch.puzzle.workshop.springboot.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}