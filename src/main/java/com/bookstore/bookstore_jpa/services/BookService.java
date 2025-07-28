package com.bookstore.bookstore_jpa.services;

import com.bookstore.bookstore_jpa.dtos.BookRecordDto;
import com.bookstore.bookstore_jpa.models.BookModel;
import com.bookstore.bookstore_jpa.models.ReviewModel;
import com.bookstore.bookstore_jpa.repositories.AuthorRepository;
import com.bookstore.bookstore_jpa.repositories.BookRepository;
import com.bookstore.bookstore_jpa.repositories.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto){
        BookModel book = new BookModel();

        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel review = new ReviewModel();

        review.setComment(bookRecordDto.reviewComment());
        review.setBook(book);

        book.setReview(review);

        return bookRepository.save(book);
    }

}
