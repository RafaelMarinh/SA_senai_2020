package br.sc.senai.controller;

import br.sc.senai.model.Book;
import br.sc.senai.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/books")
    public @ResponseBody ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        try {
            Book newBook = bookRepository.save(book);
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path = "/books")
    public @ResponseBody ResponseEntity<Iterable<Book>> getAllBooks() {

        try {
            Iterable<Book> books = bookRepository.findAll();
            if (((Collection<?>) books).size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/books/{id}")
    public @ResponseBody ResponseEntity<HttpStatus> removeBook(@PathVariable("id") Integer id) {

        try {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/books/{id}")
    public @ResponseBody ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {

        Optional<Book> bookData = bookRepository.findById(id);

        if (bookData.isPresent()) {
            Book updatedBook = bookData.get();
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setCategory(book.getCategory());
            updatedBook.setDescription(book.getDescription());
            updatedBook.setEdition(book.getEdition());
            updatedBook.setLanguage(book.getLanguage());
            updatedBook.setLoan_id(book.getLoan_id());
            updatedBook.setPages(book.getPages());
            updatedBook.setPublishing(book.getPublishing());
            updatedBook.setTitle(book.getTitle());

            return new ResponseEntity<>(bookRepository.save(updatedBook), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping(path = "/books/allbyname")
//    public @ResponseBody Iterable<Book> findByName(@RequestParam String title) {
//        return bookRepository.findAllByName(title);
//    }
}
