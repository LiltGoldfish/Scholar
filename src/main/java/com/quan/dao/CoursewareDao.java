package com.quan.dao;

import com.quan.pojo.Courseware;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CoursewareDao {
    @Select("select * from courseware where lessonID = #{lessonID}")
    @Results({@Result(property = "coursewareID", column = "coursewareID"),
            @Result(property = "lessonID", column = "lessonID"),
            @Result(property = "coursewareTitle", column = "coursewareTitle"),
            @Result(property = "publicTime", column = "publicTime"),
            @Result(property = "src", column = "src") })
    List<Courseware> getByLessonID(int lessonID);


    @Insert("insert into courseware values (null, #{lessonID} , #{coursewareTitle} ,#{publicTime}, #{src})")
    boolean add(Courseware courseware);

    @Update("update courseware set lessonID = #{lessonID} , coursewareTitle = #{coursewareTitle} , publicTime = #{publicTime} ,src = #{src} where lessonID = #{lessonID}")
    boolean update(Courseware courseware);

    @Delete("delete from courseware where coursewareID = #{id}")
    boolean deleteById(int id);

}
