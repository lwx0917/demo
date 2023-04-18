package com.husky.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "book")
public class BookEntity {
    @Id
    private Long id;
    @Field(type = FieldType.Keyword, analyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Keyword, analyzer = "ik_max_word")
    private String content;
    @Field(type = FieldType.Text)
    private String author;
    @Field(type = FieldType.Date)
    private String modifyDate;

}
