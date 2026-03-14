package com.namdev.jobportal.dto.response.resume;

import java.time.Instant;

//DTO dùng để trả về thông tin sau khi cập nhật một bản resume thành công
public class ResUpdateResumeDTO {
    private Instant updatedAt;
    private String updatedBy;

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


}
