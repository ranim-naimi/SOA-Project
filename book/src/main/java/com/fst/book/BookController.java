package com.fst.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v2/books")
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    @GetMapping("/{code}")
    public Book getBook(@PathVariable("code") Long code) {
        Book book = this.bookRepository.findBookByCode(code);
        return book;

    }

    @GetMapping("/all")
    public List<Book> getAll () {
        List<Book> books = this.bookRepository.findAll();
        return books;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook  (@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>( newBook , HttpStatus.CREATED);

    }
    @PutMapping("/update")
    // save method works in both cases where the document exist or not
    public void updateBook  (@RequestBody Book book) {
        this.bookRepository.save(book);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteBook (@PathVariable ("code") Long code) {
        if (this.bookService.deleteBook(code)) {
            return new ResponseEntity<>("book deleted", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("book not found" , HttpStatus.NOT_FOUND);

        }
    }
}
