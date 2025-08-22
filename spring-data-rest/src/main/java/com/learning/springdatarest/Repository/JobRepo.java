package com.learning.springdatarest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.learning.springdatarest.Model.JobPost;

@Repository
@RepositoryRestResource(path = "jobPosts")
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    @Override
    @RestResource(exported = true) // This ensures the repository is exposed
    List<JobPost> findAll(); // Overriding to ensure it's explicitly exposed
}