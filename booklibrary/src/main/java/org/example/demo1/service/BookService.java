package org.example.demo1.service;

import org.example.demo1.model.BookInfo;
import org.example.demo1.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    
    public List<BookInfo> getList() {
        //调用 bookDao 的 mockBookData 方法,存到 bookInfos 这个列表里
        List<BookInfo> bookInfos = bookDao.mockBookData();
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getStatus() == 1) {
                bookInfo.setStatus(1);
            } else {
                bookInfo.setStatus(0);
            }
        }
        return bookInfos;
    }

    public void addBook(){

    }

}