package cj.Sber.BootLibrary.service;

import cj.Sber.BootLibrary.model.Book;
import cj.Sber.BootLibrary.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> searchByTitle(String query) {
        return booksRepository.findByNameStartingWithIgnoreCase(query);
    }


    public Map<String, List<Book>> getStats(@NotNull String query) {
        if (!StringUtils.hasLength(query)){
            throw new RuntimeException("Query can not be null");
        }
        Map<String, List<Book>> result = new HashMap<>();
        result.put(query, searchByTitle(query));

        return result;
    }

}
