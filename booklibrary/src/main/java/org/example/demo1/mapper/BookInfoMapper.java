package org.example.demo1.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Select("""
select *
from book_info
where status <> 0
limit #{offset}, #{pageSize}
""")
    List<BookInfo> getListByPage(PageRequest pageRequest);

    @Select("select * from book_info where id=#{bookId} and status<>0")
    BookInfo queryBookById(Integer bookId);

//    @Update("""
//        update book_info
//        set book_name = #{bookName},
//            author = #{author},
//            price = #{price},
//            publish = #{publish}
//        where id = #{id}
//          and status <> 0
//    """)

    //更新或删除
    Integer updateBook(BookInfo bookInfo);

    //批量
    Integer batchDelete(List<Integer> ids);
}
