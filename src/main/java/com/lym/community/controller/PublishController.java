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
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());
        question.setCreator(user.getId());
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tags",question.getTags());
        if(question.getTitle() == null || question.getTitle().equals("")){
            model.addAttribute("errorMsg", "标题不能为空");
            return "publish";
        }

        if(question.getDescription() == null || question.getDescription().equals("")){
            model.addAttribute("errorMsg", "问题补充不能为空");
            return "publish";
        }

        if(question.getTags() == null || question.getTags().equals("")){
            model.addAttribute("errorMsg", "标签不能为空");
            return "publish";
        }

        if (user == null) {
            model.addAttribute("errorMsg", "用户未登录");
            return "publish";
        }
        questionMapper.create(question);
        return "redirect:/";
    }

}
