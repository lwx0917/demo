package com.husky.utils;

import com.husky.constant.CodeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("统一返回结果")
public class Result {


    @ApiModelProperty("返回结果")
    private Boolean success;
    @ApiModelProperty("返回消息")
    private String message;
    @ApiModelProperty("返回状态码")
    private Integer code;
    @ApiModelProperty("返回数据")
    private Map<String, Object> data = new HashMap<>();

    public static Result success() {
        Result result = new Result();
        result.success = true;
        result.message = "操作成功";
        result.code = CodeConstant.SUCCESS;
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.success = false;
        result.message = "操作失败";
        result.code = CodeConstant.ERROR;
        return result;
    }

    private Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> data) {
        this.data = data;
        return this;
    }
}
