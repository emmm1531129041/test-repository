package org.example.demo1.controller;

import org.example.demo1.model.BookInfo;
import org.example.demo1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    //Controller调用Service层
    @Autowired
    private BookService bookService;

    //Service调用dao层
    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        return bookService.getList();
    }
}