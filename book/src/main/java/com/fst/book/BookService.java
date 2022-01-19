package com.fst.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;


    public Book addBook (Book book) {

        return bookRepository.insert(book) ;
    }

    public boolean deleteBook(Long code) {
        boolean exists = this.bookRepository.existsById(code);
        if (!exists) {
            return false ;
        }
        bookRepository.deleteById(code);
        return true ;

    }
}
