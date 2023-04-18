package com.husky.demo.service.impl;

import com.husky.demo.entity.BookEntity;
import com.husky.demo.mapper.BookMapper;
import com.husky.demo.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchImpl implements ElasticSearchService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private BookMapper mapper;

    @Override
    public void addIndex() {

    }

    @Override
    public void deleteIndex(String indexName) {
        elasticsearchRestTemplate.deleteIndex(indexName);
    }

    @Override
    public void addDocument(BookEntity book) {
        mapper.save(book);
    }
}
