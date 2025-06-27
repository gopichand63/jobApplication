package com.jobApplication.demo.job.impl;

import com.jobApplication.demo.job.Job;
import com.jobApplication.demo.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceimpl implements JobService {

    private Long nextId =1L;
    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);

    }
}
