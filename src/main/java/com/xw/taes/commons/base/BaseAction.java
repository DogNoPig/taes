package com.xw.taes.commons.base;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseAction {
    HttpSession getSession(HttpServletRequest request){
        return request.getSession();
    }
	
}
