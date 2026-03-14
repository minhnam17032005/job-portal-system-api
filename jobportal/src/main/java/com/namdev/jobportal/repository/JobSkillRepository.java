package com.namdev.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namdev.jobportal.entity.JobSkill;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {

    List<JobSkill> findByJobId(Long jobId);

    List<JobSkill> findBySkillId(Long skillId);

    void deleteByJobId(Long jobId);

}