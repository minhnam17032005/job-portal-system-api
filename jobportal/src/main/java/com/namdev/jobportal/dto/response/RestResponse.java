package com.namdev.jobportal.dto.response;

//DTO dùng để trả về thông tin phản hồi của API sau khi thực hiện một hành động nào đó
public class RestResponse<T> {
        private int statusCode;
        private String error;

        //message có thể là String,ArryList
        private Object message;
        private T data;

        public int getStatusCode() {
            return statusCode;
        }
        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
        public String getError() {
            return error;
        }
        public void setError(String error) {
            this.error = error;
        }
        public Object getMessage() {
            return message;
        }
        public void setMessage(Object message) {
            this.message = message;
        }
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
    }