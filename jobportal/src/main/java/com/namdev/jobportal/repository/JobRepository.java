package com.namdev.jobportal.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.namdev.jobportal.entity.Job;
import com.namdev.jobportal.entity.Skill;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> ,JpaSpecificationExecutor<Job>{
    List<Job> findDistinctByJobSkillsSkillIn(List<Skill> skills);
}
