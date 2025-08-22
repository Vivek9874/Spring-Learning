package com.learning.SpringWebv10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.SpringWebv10.service.JobService;
import com.learning.SpringWebv10.model.*;

@Controller
public class JobController {
	
	@Autowired
	private JobService service;
	
	@RequestMapping({"/", "/home"})
	public String home() {
		return "home";
	}
	
	@RequestMapping("addjob")
	public String addjob() {
		return "addjob";
	}
	
	//data sent from the form is stored in this object, the same object is then fetched to show on success page
	//PostMapping because submitting form is a post request
	//jobPost is A DTO Object
	@PostMapping("handleForm")
	public String handleform(JobPost jobPost) { 
		service.addJobPost(jobPost);
		return "success";
	}
	
	@RequestMapping("viewalljobs")
	public String viewjobs(Model m) {
		List<JobPost> jobs = service.returnAllJobPosts();
		
		m.addAttribute("jobPosts", jobs);
		return "viewalljobs";
	}
}
