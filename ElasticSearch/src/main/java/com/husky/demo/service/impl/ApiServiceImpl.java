package com.husky.demo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.husky.demo.entity.BookEntity;
import com.husky.demo.service.ApiService;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService {

    private RestHighLevelClient restHighLevelClient;

    public ApiServiceImpl(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    @Override
    public BookEntity queryById(String index, String id) throws IOException {
        GetRequest request = new GetRequest().index(index).id(id);
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        String source = response.getSourceAsString();
        BookEntity book = JSONObject.parseObject(source, BookEntity.class);
        return book;
    }

    @Override
    public void deleteById(String index, String id) throws IOException {
        DeleteRequest request = new DeleteRequest().index(index).id(id);
        restHighLevelClient.delete(request, RequestOptions.DEFAULT);
    }

    @Override
    public List<BookEntity> queryAll(String index) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices(index);
        SearchSourceBuilder search = new SearchSourceBuilder();
        search.query(QueryBuilders.matchAllQuery());
        request.source(search);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        List<BookEntity> list = new ArrayList<>();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            BookEntity bookEntity = JSONObject.parseObject(hit.getSourceAsString(), BookEntity.class);
            list.add(bookEntity);
        }
        return list;
    }
}
