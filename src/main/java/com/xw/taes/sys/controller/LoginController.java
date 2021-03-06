package com.xw.taes.sys.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xw.taes.sys.domain.User;
import com.xw.taes.sys.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制
 *
 * @author adx
 * @date 2020/7/22 16:15
 */
@Controller
@Slf4j
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "/wLogin";
    }

    @PostMapping("/login")
    public String wlogin(User user, HttpServletRequest request, Model model){
        log.debug(user.toString());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        try{
            //登录验证
            subject.login(usernamePasswordToken);
            return "redirect:/admin/index";
        }catch (AuthorizationException e){
            e.printStackTrace();
        }
        return "redirect:/admin/error";
    }

    @RequestMapping("/error")
    public String error(Model model){
        model.addAttribute("errorMess","没有权限");
        return "/error";
    }

    @RequiresUser
    @RequestMapping("index")
    public String index(Model model){
        Subject subject = SecurityUtils.getSubject();
        String name = subject.getPrincipal().toString();
        User user = loginService.getUserByName(name);
        model.addAttribute("userName", user.getUserName());
        // String weather = redisTemplate.boundValueOps("weather").get();
        // model.addAttribute("weather",weather);
        return "/index";
    }

    // @Autowired
    // private RedisTemplate<String, String> redisTemplate;

    /**
     * 将天气信息写入缓存
     * @param map
     */
    /*@JmsListener(destination = "${myqueue}")
    public void getWeather(String map){
        System.out.println(map);
        // String weather = (String) redisTemplate.boundValueOps("weather").get();
        // if (weather == null){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String weather = objectMapper.writeValueAsString(map);
                redisTemplate.boundValueOps("weather").set(weather);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        // }
    }*/

    /**
     * shiro 退出登录流程
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String exit(HttpServletRequest request){
        //ActionContext.getContext().getSession().clear();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/wLogin";
    }
}
