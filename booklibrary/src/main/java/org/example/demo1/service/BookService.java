package org.example.demo1.service;

import org.example.demo1.enums.BookStatus;
import org.example.demo1.mapper.BookInfoMapper;
import org.example.demo1.model.BookInfo;
//import org.example.demo1.dao.BookDao;
import org.example.demo1.model.PageRequest;
import org.example.demo1.model.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
//    @Autowired
//    private BookDao bookDao;
    @Autowired
    private BookInfoMapper bookInfoMapper;

//    public List<BookInfo> getList() {
//        //调用 bookDao 的 mockBookData 方法,存到 bookInfos 这个列表里
//        List<BookInfo> bookInfos = bookDao.mockBookData();
////        for (BookInfo bookInfo : bookInfos) {
////            if (bookInfo.getStatus() == 1) {
////                bookInfo.setStatus(1);
////            } else {
////                bookInfo.setStatus(0);
////            }
////        }
//        return bookInfos;
//    }

    public void addBook(BookInfo bookInfo){
        bookInfoMapper.addBook(bookInfo);
    }

    public PageResponse<BookInfo> getListByPage(PageRequest pageRequest) {
        // 1. 查询总记录数
        Integer count = bookInfoMapper.count();
//        if (count == 0) {
//            // 没数据直接返回空结果
//            PageResponse<BookInfo> pageResponse = new PageResponse<>();
//            pageResponse.setTotal(0);
//            return pageResponse;
//        }
        if (count == 0) {
            return new PageResponse<>(count, null);  // 或 new PageResponse<>(0, null)
        }
        // 2. 计算偏移量
//        Integer offset = (pageRequest.getCurrentPage() - 1) * pageRequest.getPageSize();
        // 3. 查询当前页数据
//        List<BookInfo> bookInfos = bookInfoMapper.getListByPage(offset, pageRequest.getPageSize());
        List<BookInfo> bookInfos = bookInfoMapper.getListByPage(pageRequest);

        for (BookInfo bookInfo : bookInfos) {
//            if (bookInfo.getStatus() == 1) {
//                bookInfo.setStatus("可借阅");
//            } else if (bookInfo.getStatus() == 2) {
//                bookInfo.setStatus("不可借阅");
//            } else {
//                bookInfo.setStatus("无效");
//            }
            bookInfo.setStatusCN(BookStatus.getNameByCode(bookInfo.getStatus()));
        }
        return new PageResponse<>(count,bookInfos);
    }

    public BookInfo queryBookById(Integer bookId) {
    return bookInfoMapper.queryBookById(bookId);
    }

    public Integer updateBook(BookInfo bookInfo) {
    return bookInfoMapper.updateBook(bookInfo);
    }

    public Integer deleteBook(Integer bookId) {
        BookInfo bookInfo = new BookInfo();

        bookInfo.setId(bookId);

        bookInfo.setStatus(BookStatus.DELETED.getCode());

        return bookInfoMapper.updateBook(bookInfo);
    }

    public Integer batchDelete(List<Integer> ids) {
    return bookInfoMapper.batchDelete(ids);
    }
}