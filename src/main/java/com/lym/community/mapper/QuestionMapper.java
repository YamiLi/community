package com.lym.community.mapper;


import com.lym.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO question(title,description,gmt_create,gmt_modified,creator,tags) VALUES (#{title}," +
            "#{description},#{gmt_create},#{gmt_modified} ,#{creator},#{tags})")
    void create(Question question);

    @Select("SELECT id,title,description,gmt_create,gmt_modified,creator,comment_count,view_count,like_count,tags " +
            "FROM question LIMIT #{offset},#{size}")
    List<Question> findAllQuestion(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("SELECT COUNT(1) FROM question")
    Integer count();

}
