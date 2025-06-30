package com.jobApplication.demo.job.impl;

import com.jobApplication.demo.Company.Company;
import com.jobApplication.demo.Company.CompanyRepository;
import com.jobApplication.demo.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceimpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceimpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }



    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
