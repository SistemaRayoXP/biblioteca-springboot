package mx.udg.biblioteca.repositories;

import mx.udg.biblioteca.models.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long> {
    public Optional<BookModel> findByIsbn(Long isbn);
    public ArrayList<BookModel> findAllByTitle(String title);
    public ArrayList<BookModel> findAllByYear(int year);
    public ArrayList<BookModel> findAllByPublisher(String publisher);
    public void deleteByIsbn(Long isbn);
}
