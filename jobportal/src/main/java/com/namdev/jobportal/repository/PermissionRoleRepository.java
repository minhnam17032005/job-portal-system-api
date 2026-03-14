package com.namdev.jobportal.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namdev.jobportal.entity.PermissionRole;


@Repository
public interface PermissionRoleRepository extends JpaRepository<PermissionRole, Long> {

    List<PermissionRole> findByRoleId(Long roleId);

    List<PermissionRole> findByPermissionId(Long permissionId);

    void deleteByRoleId(Long roleId);

}