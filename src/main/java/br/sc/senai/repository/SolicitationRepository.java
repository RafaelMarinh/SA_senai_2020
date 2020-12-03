package br.sc.senai.repository;

import br.sc.senai.model.Solicitation;
import org.springframework.data.repository.CrudRepository;

public interface SolicitationRepository extends CrudRepository<Solicitation, Integer> {

//    @Query(value = "SELECT e FROM Books e WHERE e.title = :title")
//    Collection<Book> findAllByName(@Param("title") String title);
}
