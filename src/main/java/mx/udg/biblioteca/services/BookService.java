package mx.udg.biblioteca.services;

import mx.udg.biblioteca.models.BookModel;
import mx.udg.biblioteca.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookModel addBook(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public Optional<BookModel> getBookByISBN(Long isbn) {
        return bookRepository.findById(isbn);
    }

    public ArrayList<BookModel> getAllBooks() {
        return (ArrayList<BookModel>) bookRepository.findAll();
    }

    public ArrayList<BookModel> findBooksByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    public ArrayList<BookModel> findBooksByYear(int year) {
        return bookRepository.findAllByYear(year);
    }

    public ArrayList<BookModel> findBooksByPublisher(String publisher) {
        return bookRepository.findAllByPublisher(publisher);
    }

    public Optional<BookModel> modifyBook(BookModel bookModel) {
        Optional<BookModel> existingModel = bookRepository.findByIsbn(bookModel.getIsbn());
        if (existingModel.isPresent()) {
            BookModel model = existingModel.get();
            model.setTitle(bookModel.getTitle());
            model.setAuthor(bookModel.getAuthor());
            model.setPublisher(bookModel.getPublisher());
            model.setYear(bookModel.getYear());
            existingModel = Optional.of(bookRepository.save(model));
        }
        return existingModel;
    }

    public String deleteBook(Long isbn) {
        if (bookRepository.findByIsbn(isbn).isEmpty()) {
            return String.format("Book with ISBN %s not found", isbn);
        } else {
            bookRepository.deleteByIsbn(isbn);
            return String.format("Book with ISBN %s deleted successfully", isbn);
        }
    }
}
