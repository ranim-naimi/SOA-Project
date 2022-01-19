package com.fst.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository <Book, Long> {
    Book findBookByCode(Long code);

}
