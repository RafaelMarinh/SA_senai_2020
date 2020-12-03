package br.sc.senai.controller;

import br.sc.senai.model.Solicitation;
import br.sc.senai.repository.SolicitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class SolicitationController {

    @Autowired
    private SolicitationRepository solicitationRepository;

    @PostMapping(path = "/solicitations")
    public @ResponseBody ResponseEntity<Solicitation> add(@RequestBody Solicitation solicitation) {
        try {
            Solicitation newSolicitation = solicitationRepository.save(solicitation);
            return new ResponseEntity<>(newSolicitation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/solicitations")
    public @ResponseBody ResponseEntity<Iterable<Solicitation>> getAll() {

        try {
            Iterable<Solicitation> solicitations = solicitationRepository.findAll();
            if (((Collection<?>) solicitations).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(solicitations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/solicitations/{id}")
    public @ResponseBody ResponseEntity<HttpStatus> remove(@PathVariable("id") Integer id) {

        try {
            solicitationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/solicitations/{id}")
    public @ResponseBody ResponseEntity<Solicitation> update(@PathVariable("id") Integer id, @RequestBody Solicitation solicitation) {

        Optional<Solicitation> solicitationData = solicitationRepository.findById(id);

        if (solicitationData.isPresent()) {
            Solicitation updated = solicitationData.get();

            return new ResponseEntity<>(solicitationRepository.save(updated), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
