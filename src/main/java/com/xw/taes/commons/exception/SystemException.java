package com.xw.taes.commons.exception;

/**
 * 系统异常处理
 *
 * @author adx
 * @date 2020/7/24 9:52
 */
public class SystemException extends RuntimeException {
    private String code;

    public SystemException(UserResponseEnum userResponseEnum) {
        super(userResponseEnum.getDescription());
        this.code = userResponseEnum.getCode();
    }

    public String getCode() {
        return code;
    }
}
