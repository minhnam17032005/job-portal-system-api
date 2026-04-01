package com.namdev.jobportal.controller;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namdev.jobportal.service.PermissionService;
import com.namdev.jobportal.util.annotation.ApiMessage;
import com.namdev.jobportal.dto.response.ResultPaginationDTO;
import com.namdev.jobportal.entity.Permission;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.turkraft.springfilter.boot.Filter;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/v1")
public class PermissionController {
    private final PermissionService permissionService; 
    public PermissionController (PermissionService permissionService){
        this.permissionService = permissionService;
    }

    @PostMapping("/permissions")
    @ApiMessage("Create a permission")
    public ResponseEntity<Permission> create(@Valid @RequestBody Permission p) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.permissionService.create(p));
    }

    @PutMapping("/permissions")
    @ApiMessage("Update a permission")
    public ResponseEntity<Permission> update(@Valid @RequestBody Permission p) {
        Permission result = this.permissionService.update(p);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/permissions/{id}")
    @ApiMessage("delete a permission")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        this.permissionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/permissions")
    @ApiMessage("Fetch permissions")
    public ResponseEntity<ResultPaginationDTO> getPermissions(
            @Filter Specification<Permission> spec,
            Pageable pageable) {

        return ResponseEntity.ok(
            this.permissionService.getPermissions(spec, pageable)
        );
    }



}
