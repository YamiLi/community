package com.lym.community.controller;

import com.lym.community.dto.QuestionDto;
import com.lym.community.mapper.UserMapper;
import com.lym.community.model.User;
import com.lym.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/")
    public String index(HttpServletRequest request,Model models) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        List<QuestionDto> allQuestion = questionService.findAllQuestion();
        for (QuestionDto questionDto : allQuestion) {
            questionDto.setTitle("标题1");
        }

        models.addAttribute("allQuestion",allQuestion);
        return "index";
    }

}
