package com.husky.demo.mapper;

import com.husky.demo.entity.BookEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends ElasticsearchRepository<BookEntity, Long> {
}
