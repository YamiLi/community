package com.lym.community.controller;


import com.lym.community.mapper.QuestionMapper;
import com.lym.community.mapper.UserMapper;
import com.lym.community.model.Question;
import com.lym.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/publish")
    public String publish() {
        return "publish";
    }

    @RequestMapping("/doPublish")
    public String doPublish(Question question, HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("errorMsg", "用户未登录");
            return "publish";
        }
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());
        questionMapper.create(question);
        return "redirect:/";
    }

}
