package com.namdev.jobportal.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
//dùng để đánh dấu một phương thức với một thông điệp cụ thể, có thể được sử dụng để cung cấp thông tin bổ sung về phương thức đó, chẳng hạn như mô tả hoặc mục đích của nó.
public @interface ApiMessage {
    String value();
}
