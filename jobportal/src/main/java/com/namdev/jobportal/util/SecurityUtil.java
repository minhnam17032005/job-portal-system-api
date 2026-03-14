package com.namdev.jobportal.util;
import java.util.Optional;
// 1. Tạo JWT token
// 2. Kiểm tra JWT token
// 3. Lấy user đang đăng nhập
// 4. Lấy token hiện tại
public class SecurityUtil {

    public static Optional<String> getCurrentUserLogin() {
        return Optional.of("system");
    }

}
