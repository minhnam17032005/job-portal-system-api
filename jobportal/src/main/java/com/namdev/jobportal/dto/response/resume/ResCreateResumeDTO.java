package com.namdev.jobportal.dto.response.resume;

import java.time.Instant;

//DTO dùng để trả về thông tin sau khi tạo mới một bản resume thành công
public class ResCreateResumeDTO {
    private long id ;
    private Instant createdAt;
    private String createdBy;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}

