package com.jobApplication.demo.job.impl;

import com.jobApplication.demo.Company.Company;
import com.jobApplication.demo.Company.CompanyRepository;
import com.jobApplication.demo.Company.CompanyService;
import com.jobApplication.demo.job.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceimpl implements CompanyService {

    private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;

    public CompanyServiceimpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);

        if (optionalCompany.isPresent()) {
            Company existingCompany = optionalCompany.get();

            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
            existingCompany.setJobs(company.getJobs()); // optional: if jobs are being updated

            companyRepository.save(existingCompany);
            return true;
        }

        return false; // Company with given ID not found
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }


    @Override
    public boolean deleteCompanyById(Long id) {
        Optional<Company> companyOpt = companyRepository.findById(id);
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            jobRepository.deleteAll(company.getJobs()); // First delete jobs
            companyRepository.deleteById(id);           // Then delete company
            return true;
        }
        return false;
    }


    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

}
