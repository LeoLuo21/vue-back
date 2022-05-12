package com.pale.view.response;

public class R<T> {
    private Integer code;
    private String message;
    private T data;

    public R() {
    }

    public static R ok() {
        R<Object> res =  new R<>();
        res.setCode(200);
        res.setMessage("ok");
        return  res;
    }

    public static R ok(String message) {
        R<Object> res =  new R<>();
        res.setCode(200);
        res.setMessage(message);
        return  res;
    }

    public static <T> R<T> ok(T data) {
        R<T> res =  new R<>();
        res.setCode(200);
        res.setMessage("ok");
        res.setData(data);
        return  res;
    }

    public static <T> R<T> ok(String message, T data) {
        R<T> res =  new R<>();
        res.setCode(200);
        res.setMessage(message);
        res.setData(data);
        return  res;
    }

    public static R fail() {
        R<Object> res =  new R<>();
        res.setCode(500);
        res.setMessage("failure");
        return  res;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public T getTata() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
