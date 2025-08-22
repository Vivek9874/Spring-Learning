package com.learning.SpringWebv10.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.learning.SpringWebv10.model.JobPost;

@Repository
public class JobRepo {

    private final List<JobPost> jobs = new ArrayList<>();

    public JobRepo() {
        // Initialize sample job posts
        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
        jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                List.of("HTML", "CSS", "JavaScript", "React")));
        jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));
    }

    // Method name matches your service call
    public List<JobPost> returnAllJobPosts() {
        return Collections.unmodifiableList(jobs);
    }

    // Add a new job post
    public void addJobPost(JobPost job) {
        jobs.add(job);
    }
}
