package com.vk.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vk.entity.Actor;
import com.vk.service.IActorMgmtService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ActorControllMgmt {
	
	@Autowired
	private IActorMgmtService service;

	@GetMapping("/")
	public String homePage() {
		//return LVN
		return "homePage" ;
	}
	
	@GetMapping("/register")
	public String lunchFormPage( @ModelAttribute("actor") Actor act) {		
		//return LVN
		 return "reg_form_page" ;
	}
	
	@PostMapping("/register")
	public String regActor( @ModelAttribute("actor") Actor actor ,
			 @RequestParam("file") MultipartFile file, Map<String ,Object> map ) {
		System.out.println(actor.getImage()+"::image");
		 String result="";
		 try {
			 actor.setImage(file.getBytes());
			  result = service.registerActor(actor);
	           // model.addAttribute("imageId", saved.getId());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }		
		map.put("msg", result);
		return "homePage";
	}
	
	@GetMapping("/report")
	public String showReport(Map<String,Object> map) {
		List<Actor> actorsList = service.showReport();
		map.put("actorsList", actorsList);
		return "show_report";
	}
	
	@GetMapping("/image")
	public void getImage(@RequestParam("id") Integer id, HttpServletResponse response) throws IOException {
	    Actor actor = service.fetchActorById(id); 

	    if (actor != null && actor.getImage() != null) {
	        response.setContentType("image/jpeg"); // or "image/png" based on your image
	        response.getOutputStream().write(actor.getImage());
	        response.getOutputStream().flush();
	    }
	}

}
