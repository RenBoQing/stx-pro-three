package com.stx.pro.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年03月26日 21:08
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonObject<T> {
    private Integer code;
    private String message;
    private List<T> data;
    private Long count;
    public static JsonObject<Object> success(String message) {
        return new JsonObject(0, message, null, null);
    }
    public static JsonObject<Object> fail(String message) {
        return new JsonObject(1, message, null, null);
    }
    public static JsonObject<Object> success(Integer code, Object data, String message, Long count) { return new JsonObject(code, message, (List) data, count); }
    public static JsonObject<Object> fail(Integer code,String message) { return new JsonObject(code, message, null, null); }
    public static JsonObject<Object> success(Integer code,String message) { return new JsonObject(code, message, null, null); }
}
