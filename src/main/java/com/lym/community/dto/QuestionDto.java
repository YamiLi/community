package com.lym.community.dto;

import com.lym.community.model.User;
import lombok.Data;

@Data
public class QuestionDto {

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
    private User user;
}
