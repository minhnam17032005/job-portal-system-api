package com.namdev.jobportal.dto.response.file;
import java.time.Instant;
//DTO dùng để trả về thông tin sau khi upload file thành công
public class ResUploadFileDTO {
    private String fileName;
    private Instant uploadedAt;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Instant getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Instant uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public ResUploadFileDTO() {
    }
    
    public ResUploadFileDTO(String fileName, Instant uploadedAt) {
        this.fileName = fileName;
        this.uploadedAt = uploadedAt;
    }

    
}

