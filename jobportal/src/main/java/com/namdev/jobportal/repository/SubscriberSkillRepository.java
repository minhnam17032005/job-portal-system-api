package com.namdev.jobportal.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namdev.jobportal.entity.SubscriberSkill;

@Repository
public interface SubscriberSkillRepository extends JpaRepository<SubscriberSkill, Long> {

    List<SubscriberSkill> findBySubscriberId(Long subscriberId);

    List<SubscriberSkill> findBySkillId(Long skillId);

    void deleteBySubscriberId(Long subscriberId);

}