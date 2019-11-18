package com.lym.community.model;


import lombok.Data;
import org.apache.ibatis.annotations.Insert;

@Data
public class Question {

    private int id;
    private String title;
    private String description;
    private String tags;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;

}
