package com.shopping.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class WelcomeController {
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	   public String display() {
	      return "home.jsp";
	   }
	 
	 @RequestMapping("/home")  
	    public ModelAndView displayHome(HttpServletRequest request,HttpServletResponse response)  
	    {  
		 
		
			
			ModelAndView mv=new ModelAndView();
			mv.setViewName("home.jsp");
			
	    return mv;
	  
	    } 
	 @RequestMapping("/products")  
	    public ModelAndView displayProducts(HttpServletRequest request,HttpServletResponse response)  
	    {  
			
			ModelAndView mv=new ModelAndView();
			mv.setViewName("products.jsp");
			
	    return mv;
	  
	    } 
	 @RequestMapping("/contact")  
	    public ModelAndView displayContact(HttpServletRequest request,HttpServletResponse response)  
	    {  
			
			ModelAndView mv=new ModelAndView();
			mv.setViewName("contact.jsp");
			
	    return mv;
	  
	    }
	 @RequestMapping("/login")  
	    public ModelAndView displayUser(HttpServletRequest request,HttpServletResponse response)  
	    {  
			
			ModelAndView mv=new ModelAndView();
			mv.setViewName("login.jsp");
			
	    return mv;
	  
	    } 
	 @RequestMapping("/registration")  
	    public ModelAndView displayRegistration(HttpServletRequest request,HttpServletResponse response)  
	    {  
			
			ModelAndView mv=new ModelAndView();
			mv.setViewName("registration.jsp");
			
	    return mv;
	  
	    } 
	/*@RequestMapping("/home")  
    public ModelAndView display(HttpServletRequest request,HttpServletResponse response)  
    {  
		int a=Integer.parseInt(request.getParameter("t1"));
		int b=Integer.parseInt(request.getParameter("t2"));
		int c=a+b;
		ModelAndView mv=new ModelAndView();
		mv.setViewName("return.jsp");
		mv.addObject("result",c);
    return mv;
  
    } */   
}
