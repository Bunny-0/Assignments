package com.example.assignment1.assignment1.Controller;


import com.example.assignment1.assignment1.Model.Book;
import com.example.assignment1.assignment1.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//        saveOne()-->ReturnResponseEntity<Book,Http> created book object as response.  (RequestBody) /books/create-book
//        GetOne(id)-->Return Book (pathParam)    /books/get-book-by-id/{id}
//        GetAll--->Return List<Books>      /books/get-all-books
//        BookByAuthor(Author)--->Return Book--->RequestParam   /books/get-books-by-author?author=author+name
//        GetBookByGenre(Genre)--->Return Book --->RequestParam     /books/get-books-by-genre?genre=genre+name
//        DeleteBook(id)-->ResponseEntity<null,status>   ///string     /books/delete-book-by-id/{id}
//        DeleteBook(id)-->ResponseEntity     //// /books/delete-all-books\

@RestController
public class BookController {



  @Autowired
  BookRepository books;

    @PostMapping("/books/create-book")
    ResponseEntity createBook(@RequestBody Book book){
        books.createBook(book);
        return new ResponseEntity<>(book,HttpStatus.CREATED);

    }

    @GetMapping("/books/get-book-by-id/{id}")
    Book getBookById(@PathVariable int id){
        Book res= books.getBookById(id);
        return res;

    }

    @GetMapping("/books/get-books-by-author")
    Book getBookByAuthor(@RequestParam(name = "author") String name){
        Book res= books.getBookByAuthor(name);
        return res;

    }

    @GetMapping("/books/get-all-books")
    List<Book> getAllBooks(){
        List<Book> res= books.getAllBook();
        return res;

    }


    @GetMapping("/books/get-books-by-genre")
    @ResponseBody
    Book getBookByGenre(@RequestParam(name = "genre") String name){
        Book res= books.getBookByGenre(name);
        return res;

    }

    @DeleteMapping("/books/delete-book-by-id/{id}")
    ResponseEntity getAllBooks(@PathVariable int id){
        books.deleteBookById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);


    }
    @DeleteMapping("/books/delete-all-books")
    ResponseEntity deleteBook(){
        books.deleteAllBooks();
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }


}
