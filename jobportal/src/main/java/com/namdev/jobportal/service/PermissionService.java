package com.namdev.jobportal.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.namdev.jobportal.dto.response.ResultPaginationDTO;
import com.namdev.jobportal.entity.Permission;
import com.namdev.jobportal.repository.PermissionRepository;
import com.namdev.jobportal.util.error.IdInvalidException;
import com.namdev.jobportal.repository.PermissionRoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PermissionService {
    private final PermissionRepository permissionRepository;
    private final PermissionRoleRepository rolePermissionRepository; 
    public PermissionService (PermissionRepository permissionRepository, PermissionRoleRepository rolePermissionRepository){
        this.permissionRepository=permissionRepository;
        this.rolePermissionRepository=rolePermissionRepository;
    }

    public boolean isPermissionExist(Permission p) {
        return permissionRepository.existsByModuleAndApiPathAndMethod(
                p.getModule(),
                p.getApiPath(),
                p.getMethod()
        );
    }

    public Permission fetchById(long id) {
        return this.permissionRepository.findById(id)
                .orElseThrow(() -> new IdInvalidException("Permission với id = " + id + " không tồn tại"));
    }

    public Permission create(Permission p) {
        // check exist theo bộ 3 unique
        boolean isExist = this.permissionRepository.existsByModuleAndApiPathAndMethod(
                        p.getModule(),
                        p.getApiPath(),
                        p.getMethod());
        if (isExist) { throw new IdInvalidException(
                    "Permission đã tồn tại với module = " + p.getModule() +
                    ", apiPath = " + p.getApiPath() +
                    ", method = " + p.getMethod());
        }
        return this.permissionRepository.save(p);
    }

    public Permission update(Permission p) {
        //check tồn tại theo id (đã throw nếu không có)
        Permission permissionDB = this.fetchById(p.getId());
        //check trùng (module + apiPath + method)
        boolean isExist = this.permissionRepository
                .existsByModuleAndApiPathAndMethod(
                        p.getModule(),
                        p.getApiPath(),
                        p.getMethod());

        if (isExist) {
            // check có phải chính nó không
            boolean isSame = permissionDB.getModule().equals(p.getModule())
                    && permissionDB.getApiPath().equals(p.getApiPath())
                    && permissionDB.getMethod().equals(p.getMethod());

            if (!isSame) {
                throw new IdInvalidException(
                        "Permission đã tồn tại với module = " + p.getModule() +
                        ", apiPath = " + p.getApiPath() +
                        ", method = " + p.getMethod());
            }
        }
        //update field
        permissionDB.setName(p.getName());
        permissionDB.setApiPath(p.getApiPath());
        permissionDB.setMethod(p.getMethod());
        permissionDB.setModule(p.getModule());

        return this.permissionRepository.save(permissionDB);
    }

    public void delete(long id) {
        //check tồn tại
        Permission currentPermission = this.fetchById(id);

        //xóa tất cả quan hệ ở bảng trung gian
        this.rolePermissionRepository.deleteByPermissionId(id);

        //xóa permission
        this.permissionRepository.delete(currentPermission);
    }

    public ResultPaginationDTO getPermissions(Specification<Permission> spec,Pageable pageable) {

        Page<Permission> pPermissions =
                this.permissionRepository.findAll(spec, pageable);

        ResultPaginationDTO rs = new ResultPaginationDTO();
        ResultPaginationDTO.Meta mt = new ResultPaginationDTO.Meta();

        mt.setPage(pageable.getPageNumber() + 1);
        mt.setPageSize(pageable.getPageSize());
        mt.setPages(pPermissions.getTotalPages());
        mt.setTotal(pPermissions.getTotalElements());

        rs.setMeta(mt);
        rs.setResult(pPermissions.getContent());
        return rs;
    }


}
