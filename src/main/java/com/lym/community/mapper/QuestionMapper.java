package com.lym.community.mapper;


import com.lym.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO question(title,description,gmt_create,gmt_modified,creator,tags) VALUES (#{title}," +
            "#{description},#{gmt_create},#{gmt_modified} ,#{creator},#{tags})")
    void create(Question question);
}
