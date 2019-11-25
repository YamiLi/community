package com.lym.community.service;

import com.lym.community.dto.PageDto;
import com.lym.community.model.Question;

import java.util.List;

public interface QuestionService {

    PageDto findAllQuestion(Integer page, Integer size);

    PageDto listByUserId(int userId,Integer page,Integer size);

}
