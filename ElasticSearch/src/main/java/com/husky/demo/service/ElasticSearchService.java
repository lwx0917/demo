package com.husky.demo.service;

import com.husky.demo.entity.BookEntity;
import org.springframework.stereotype.Service;


@Service
public interface ElasticSearchService {

    void addIndex();

    void deleteIndex(String indexName);

    void addDocument(BookEntity book);
}
