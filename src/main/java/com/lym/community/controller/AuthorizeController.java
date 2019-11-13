package com.lym.community.controller;

import com.lym.community.dto.AccessTokenDto;
import com.lym.community.dto.GithubUser;
import com.lym.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,@RequestParam(name = "state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("c0e431ea8701e48a685a");
        accessTokenDto.setClient_secret("a27e49cb6153aebd4d29c929228cbdfa0ec7f5ef");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }

}
