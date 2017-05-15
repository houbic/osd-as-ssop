package com.osd.ssop.constant;

/**
 * Created by chenbinghao on 16/9/1.下午3:51
 */
public enum ErrorCode {

    USER_LOGIN_SUCCESS(200, "success"),

    USER_NOTEXISTS_ERROR(410, "user  not exists"),

    USER_PWD_ERROR(411, "password error"),

    CODE_VALIDATE_ERROR(412, "codeValidate error"),

    APP_NULL_ERROR(413, "app is null"),

    ;

    private int code;

    private String message;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message =message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
