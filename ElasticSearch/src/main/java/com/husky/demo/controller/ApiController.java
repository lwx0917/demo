package com.husky.demo.controller;

import com.husky.demo.entity.BookEntity;
import com.husky.demo.service.ApiService;
import com.husky.utils.Result;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/java/api")
public class ApiController {

    private ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("queryById")
    public Result queryById(String index, String id) throws IOException {
        BookEntity book = apiService.queryById(index, id);
        return Result.success().data("book", book);
    }

    @DeleteMapping("deleteById")
    public Result deleteById(String index, String id) throws IOException {
        apiService.deleteById(index, id);
        return Result.success();
    }

    @GetMapping("queryAll")
    public Result queryAll(String index) throws IOException {
        List<BookEntity> list = apiService.queryAll(index);
        return Result.success().data("list", list);
    }
}
