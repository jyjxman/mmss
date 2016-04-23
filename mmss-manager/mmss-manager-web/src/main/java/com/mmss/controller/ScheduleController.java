package com.mmss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController{
    @RequestMapping("/create")
	public String create() {
		
		return "/workflow/create";
	}
    @RequestMapping("/list")
    public String list() {
    	
    	return "/workflow/list";
    }
    @RequestMapping("/checklist")
    public String checklist() {
    	
    	return "/workflow/checklist";
    }
    @RequestMapping("/disposelist")
    public String disposelist() {
    	
    	return "/workflow/disposelist";
    }
    @RequestMapping("/grouptasklist")
    public String grouptasklist() {
    	
    	return "/workflow/grouptasklist";
    }
    @RequestMapping("/tasklist")
    public String tasklist() {
    	
    	return "/workflow/tasklist";
    }
   
	
	
	
}
