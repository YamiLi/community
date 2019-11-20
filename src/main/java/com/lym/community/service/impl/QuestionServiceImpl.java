package com.lym.community.service.impl;

import com.lym.community.dto.PageDto;
import com.lym.community.dto.QuestionDto;
import com.lym.community.mapper.QuestionMapper;
import com.lym.community.mapper.UserMapper;
import com.lym.community.model.Question;
import com.lym.community.model.User;
import com.lym.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public PageDto findAllQuestion(Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        List<QuestionDto> list = new ArrayList<>();
        List<Question> allQuestion = questionMapper.findAllQuestion(offset,size);
        PageDto pageDto = new PageDto();
        for (Question question : allQuestion) {
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            list.add(questionDto);
        }
        pageDto.setQuestions(list);
        Integer totalCount = questionMapper.count();
        pageDto.setPage(totalCount,page,size);
        return pageDto;
    }
}
