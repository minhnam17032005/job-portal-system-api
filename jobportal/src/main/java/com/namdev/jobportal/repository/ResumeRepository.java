package com.namdev.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.namdev.jobportal.entity.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume,Long> ,JpaSpecificationExecutor<Resume>{

}
