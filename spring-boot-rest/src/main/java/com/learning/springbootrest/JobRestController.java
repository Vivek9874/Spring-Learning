package com.learning.springbootrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springbootrest.model.JobPost;
import com.learning.springbootrest.service.JobService;

@RestController //will send json data by default, compared to standard view data
@CrossOrigin(origins = "http://localhost:3000")//enables cors support
public class JobRestController {
	
	@Autowired
	private JobService service;
	
	
	@GetMapping(path="jobPosts", produces="application/json")
	@ResponseBody //treats the method to specifically send json data instead of default view
	public List<JobPost> getAllJobs(){
		return service.getAllJobPosts();
	}
	
	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable int postId) {
		return service.getJob(postId);
		
	}
	
	@PostMapping(path="jobPost", consumes="application/json")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		service.addJobPost(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId) {
		service.deleteJob(postId);
		return "deleted";
	}
	
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
		return service.findByKeyword(keyword);
	}
	
	@GetMapping("load")
	public String loadData() {
		service.load();
		return "success";
	}

}
