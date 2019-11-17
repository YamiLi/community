package com.lym.community.service;

import com.lym.community.dto.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> findAllQuestion();

}
