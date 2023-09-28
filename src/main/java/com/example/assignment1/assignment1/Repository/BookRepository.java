package com.example.assignment1.assignment1.Repository;

import com.example.assignment1.assignment1.Model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class BookRepository {

    HashMap<Integer, Book> map =new HashMap<Integer, Book>();
    List<Book> books=new ArrayList<>();
    static int id=0;

    public Book createBook(Book book){
        map.put(id,book);
        id++;
        return book;
    }

    public Book getBookById(int id){

        for(Book buk:map.values()){
            if(buk.getId()==id){
                return buk;
            }
        }
        return null;
    }

    public Book getBookByAuthor(String author){

        for(Book buk:map.values()){
            if(buk.getAuthor().equals(author)){
                return buk;
            }
        }
        return null;
    }
    public Book getBookByGenre(String genre){

        for(Book buk:map.values()){
            if(buk.getGenre().equals(genre)){
                return buk;
            }
        }
        return null;
    }

    public List<Book> getAllBook(){

        for(Book buk :map.values()){
            books.add(buk);
        }
        return books;
    }

    public void deleteBookById(int id){

        Book temp=null;
        for(Book buk:map.values()){
            if(buk.getId()==id){
                temp=buk;
                break;
            }
        }

        for(Integer fetch:map.keySet()){
            if(map.get(fetch).equals(temp)){
                map.remove(fetch);
                return;
            }
        }
    }

    public void deleteAllBooks(){
        map.clear();
    }

}
