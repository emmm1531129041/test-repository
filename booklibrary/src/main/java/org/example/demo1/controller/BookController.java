package org.example.demo1.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.demo1.model.BookInfo;
import org.example.demo1.model.PageRequest;
import org.example.demo1.model.PageResponse;
import org.example.demo1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    //Controller调用Service层
    @Autowired
    private BookService bookService;
    @Autowired
    private PageRequest pageRequest;

    //Service调用dao层
    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        return bookService.getList();
    }

    @GetMapping("/getListByPage")
    public PageResponse<BookInfo> getListByPage(){
        // 调用Service层分页查询
        return bookService.getListByPage(pageRequest);
    }

    @PostMapping("/addBook")
    private String addBook(BookInfo bookInfo){
        log.info("添加图书,bookInfo:{}",bookInfo);
        if (!StringUtils.hasText(bookInfo.getBookName())
                || !StringUtils.hasText(bookInfo.getAuthor())
                || bookInfo.getCount() == null
                || bookInfo.getPrice() == null
                || !StringUtils.hasText(bookInfo.getPublish())
                || bookInfo.getStatus() == null) {
            return "输入参数不合法，请检查入参";
        }

        //参数合法
        try {
            bookService.addBook(bookInfo);
        } catch (Exception e) {
            log.error("添加图书异常，e:", e);
            return e.getMessage();
        }
        return "";
    }

}