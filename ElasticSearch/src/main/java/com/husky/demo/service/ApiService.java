package com.husky.demo.service;

import com.husky.demo.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ApiService {
    BookEntity queryById(String index, String id) throws IOException;

    void deleteById(String index, String id) throws IOException;

    List<BookEntity> queryAll(String index) throws IOException;
}
