package org.example.demo1.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.demo1.model.BookInfo;
import org.example.demo1.model.PageRequest;
import org.example.demo1.model.PageResponse;
import org.example.demo1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    //Controller调用Service层
    @Autowired
    private BookService bookService;

//    //Service调用dao层
//    @RequestMapping("/getList")
//    public List<BookInfo> getList() {
//        return bookService.getList();
//    }

    //获取
    @GetMapping("/getListByPage")
    public PageResponse<BookInfo> getListByPage(PageRequest pageRequest) {
        return bookService.getListByPage(pageRequest);
    }

    //添加
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

    //查询图书
    @GetMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId) {
        log.info("查询图书详情，bookId:{}", bookId);
        BookInfo bookInfo = bookService.queryBookById(bookId);
        return bookInfo;
    }

    //更新图书
    @PostMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        log.info("更新图书信息，bookInfo:{}", bookInfo);
        if (bookInfo == null || bookInfo.getId() == null) {
            return "图书ID不能为空";
        }
        try {
            Integer result = bookService.updateBook(bookInfo);
            return result == 1 ? "" : "更新失败";
        } catch (Exception e) {
            log.error("更新图书失败，e:", e);
            return "更新失败";
        }
    }

    //删除
    @PostMapping("/deleteBook")
    public String deleteBook(Integer bookId) {
        log.info("删除图书，bookId:" + bookId);
        try {
            Integer result = bookService.deleteBook(bookId);
            return result == 1 ? "" : "图书删除失败";
        } catch (Exception e) {
            log.error("图书删除失败，e:", e);
            return "图书删除失败";
        }
    }

    //批量删除
    @PostMapping("/batchBook")
    public String batchDeleteBook(@RequestParam List<Integer> ids){
        log.info("批量删除图书，ids:{}", ids);
        try {
            bookService.batchDelete(ids);
            return "";
        } catch (Exception e){
            log.error("批量删除图书失败，e:", e);
            return "批量删除图书失败";
        }
    }

}