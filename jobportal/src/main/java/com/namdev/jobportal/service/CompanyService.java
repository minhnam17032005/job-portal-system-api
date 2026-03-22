package com.namdev.jobportal.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.namdev.jobportal.dto.response.ResultPaginationDTO;
import com.namdev.jobportal.entity.Company;
import com.namdev.jobportal.entity.Job;
import com.namdev.jobportal.entity.User;
import com.namdev.jobportal.repository.CompanyRepository;
import com.namdev.jobportal.repository.JobRepository;
import com.namdev.jobportal.repository.UserRepository;
import com.namdev.jobportal.util.error.IdInvalidException;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository ;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    public CompanyService( CompanyRepository companyRepository,UserRepository userRepository,JobRepository jobRepository){
        this.companyRepository=companyRepository;
        this.userRepository =  userRepository;
        this.jobRepository = jobRepository;
    }

    //tạo công ty mới
    public Company handleCreateCompany (Company c ){
        return this.companyRepository.save(c);
    }

    //Lấy danh sách công ty
    public ResultPaginationDTO fetchAllCompanies (Specification<Company> spec, Pageable pageable){
        Page<Company> pageCompany = this.companyRepository.findAll(spec,pageable);

        ResultPaginationDTO result = new ResultPaginationDTO();
        ResultPaginationDTO.Meta meta = new  ResultPaginationDTO.Meta();
        //lấy tại phía front end
        meta.setPage(pageable.getPageNumber()+1);
        meta.setPageSize(pageable.getPageSize());

        //query và lấy tại database
        meta.setPages(pageCompany.getTotalPages());
        meta.setTotal(pageCompany.getTotalElements());

        //gán meta và kết quả vào ResultPaginationDTO
        result.setMeta(meta);
        result.setResult(pageCompany.getContent());

        return result;
    }

    //lấy công ty theo id 
    public Company fetchCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new IdInvalidException("Company with id " + id + " not found"));
    }

    //cập nhật công ty
    public Company handleUpdateCompany(Company cop) {

        Company currentCompany = fetchCompanyById(cop.getId());

        currentCompany.setName(cop.getName());
        currentCompany.setDescription(cop.getDescription());
        currentCompany.setAddress(cop.getAddress());
        currentCompany.setLogo(cop.getLogo());

        return companyRepository.save(currentCompany);    
    }

    //xóa công ty
    public void handleDeleteCompany(Long id) {

    Company company = companyRepository.findById(id)
            .orElseThrow(() -> new IdInvalidException("Company id không hợp lệ"));

    // xóa tất cả user và job liên quan đến công ty trước khi xóa công ty
    List<User> users = userRepository.findByCompany(company);
    userRepository.deleteAll(users);

    List<Job> jobs = jobRepository.findByCompany(company);
    jobRepository.deleteAll(jobs);

    // delete company
    companyRepository.delete(company);
}
}
