package com.jobApplication.demo.job.impl;

import com.jobApplication.demo.job.Job;
import com.jobApplication.demo.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceimpl implements JobService {

    private Long nextId = 1L;
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

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }

        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        return false;
    }

}
