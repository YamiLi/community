package com.lym.community.service;

import com.lym.community.dto.PageDto;

public interface QuestionService {

    PageDto findAllQuestion(Integer page, Integer size);

}
