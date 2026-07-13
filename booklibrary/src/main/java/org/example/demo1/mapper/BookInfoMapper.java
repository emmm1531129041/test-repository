package org.example.demo1.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.demo1.model.BookInfo;
import org.example.demo1.model.PageRequest;

import java.util.List;

@Mapper
public interface BookInfoMapper {

    @Insert("insert into book_info (book_name, author, count, price, publish, status) " +
            "values (#{bookName}, #{author}, #{count}, #{price}, #{publish}, #{status})")
    Integer addBook(BookInfo bookInfo);

    @Select("select count(1) from book_info where status<>0")
    Integer count();

//    @Select("select * from book_info where status<>0 limit #{offset}, #{limit}")
//    List<BookInfo> getListByPage(Integer offset, Integer limit);

    // 简化版Mapper（直接传入PageRequest对象）
    @Select("select * from book_info limit #{(currentPage-1)*pageSize}, #{pageSize}")
    List<BookInfo> getListByPage(PageRequest pageRequest);

}
