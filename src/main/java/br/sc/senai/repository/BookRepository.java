package br.sc.senai.repository;

import br.sc.senai.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface BookRepository extends CrudRepository<Book, Integer> {

//    @Query(value = "SELECT e FROM Books e WHERE e.title = :title")
//    Collection<Book> findAllByName(@Param("title") String title);
}
