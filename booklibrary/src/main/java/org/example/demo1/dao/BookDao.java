//package org.example.demo1.dao;
//
//import org.example.demo1.model.BookInfo;
//import org.springframework.stereotype.Repository;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//@Repository
//public class BookDao {
//    public List<BookInfo> mockBookData() {
//        List<BookInfo> bookInfos = new ArrayList<>(15);
//        for (int i = 1; i <= 15; i++) {
//            BookInfo bookInfo = new BookInfo();
//            bookInfo.setId(i);
//            bookInfo.setBookName("图书" + i);
//            bookInfo.setAuthor("作者" + i);
//            bookInfo.setCount(new Random().nextInt(100) + 1);
//            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100) + 1));
//            bookInfo.setPublish("出版社" + i);
//            bookInfo.setStatus(i % 5 == 0 ? 2 : 1);
//            bookInfos.add(bookInfo);
//        }
//        return bookInfos;
//    }
//}