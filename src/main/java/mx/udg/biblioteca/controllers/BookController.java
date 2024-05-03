package mx.udg.biblioteca.controllers;

import mx.udg.biblioteca.models.BookModel;
import mx.udg.biblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public ArrayList<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{isbn}")
    public Optional<BookModel> findBookByIsbn(@PathVariable Long isbn) {
        return bookService.getBookByISBN(isbn);
    }

    @GetMapping("/t/{title}")
    public ArrayList<BookModel> findBooksByTitle(@PathVariable String title) {
        return bookService.findBooksByTitle(title);
    }

    @GetMapping("/y/{year}")
    public ArrayList<BookModel> findBooksByYear(@PathVariable int year) {
        return bookService.findBooksByYear(year);
    }

    @GetMapping("/p/{publisher}")
    public ArrayList<BookModel> findBooksByPublisher(@PathVariable String publisher) {
        return bookService.findBooksByPublisher(publisher);
    }

    @PostMapping()
    public BookModel addBook(@RequestBody BookModel bookModel) {
        return bookService.addBook(bookModel);
    }

    @PutMapping()
    public Optional<BookModel> editBook(@RequestBody BookModel bookModel) {
        return bookService.modifyBook(bookModel);
    }

    @DeleteMapping("/{isbn}")
    public String deleteBook(@PathVariable() Long isbn) {
        return bookService.deleteBook(isbn);
    }
}
