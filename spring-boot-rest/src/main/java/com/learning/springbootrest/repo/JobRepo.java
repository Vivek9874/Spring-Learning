//jackson library is responsible to return the json data of java objects
//jackson-xml will do the same for POJO to XML
//JSON support is by default

package com.learning.springbootrest.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.springbootrest.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>{
	
	List<JobPost> findByPostProfileContainingOrPostDescContaining(String PostProfile, String PostDesc);
    
}


//private final List<JobPost> jobs = new ArrayList<>();
//
//public JobRepo() {
//    // Initialize sample job posts
//    jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//    jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
//            List.of("HTML", "CSS", "JavaScript", "React")));
//    jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//            List.of("Python", "Machine Learning", "Data Analysis")));
//}
//
//// Method name matches your service call
//public List<JobPost> getAllJobPosts() {
//    return Collections.unmodifiableList(jobs);
//}
//
//// Add a new job post
//public void addJobPost(JobPost job) {
//    jobs.add(job);
//}
//
//public JobPost getJob(int postId) {
//	// TODO Auto-generated method stub
//	for(JobPost job : jobs) {
//		if(job.getPostId() == postId) {
//			return job;
//		}
//	}
//	return null;
//}
//
//public void updateJob(JobPost jobPost) {
//	// TODO Auto-generated method stub
//	for (JobPost jobPost1 : jobs) {
//		if(jobPost1.getPostId() == jobPost.getPostId()) {
//			jobPost1.setPostId(jobPost.getPostId());
//			jobPost1.setPostProfile(jobPost.getPostProfile());
//			jobPost1.setPostDesc(jobPost.getPostDesc());
//			jobPost1.setReqExperience(jobPost.getReqExperience());
//			jobPost1.setPostTechStack(jobPost.getPostTechStack());
//		}
//	}
//}
//
//public void deleteJob(int postId) {
//    for(JobPost job : jobs) {
//        if(job.getPostId() == postId) {
//            jobs.remove(job); // Correctly remove the object itself
//            break; // Add a break for efficiency
//        }
//    }
//}