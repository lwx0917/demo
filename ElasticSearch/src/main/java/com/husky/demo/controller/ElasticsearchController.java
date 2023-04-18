package com.husky.demo.controller;

import com.husky.demo.entity.BookEntity;
import com.husky.demo.service.ElasticSearchService;
import com.husky.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/elasticsearch")
@Api(value = "ElasticSearch测试接口", tags = {"ElasticSearch学习", "Demo"})
public class ElasticsearchController {

    @Resource
    private ElasticSearchService esService;


    /**
     * 获取集群所有节点
     *
     * @return
     */
    @GetMapping("getNodes")
    public Result getNodes() {
        return Result.success();
    }

    /**
     * 获取集群健康状态
     *
     * @return
     */
    @GetMapping("getHealth")
    public Result getHealth() {
        return Result.success();
    }

    @PostMapping("addIndex")
    public Result addIndex() {
        esService.addIndex();
        return Result.success();
    }

    @DeleteMapping("deleteIndex")
    public Result deleteIndex(String indexName) {
        esService.deleteIndex(indexName);
        return Result.success();
    }

    @PostMapping("addDocument")
    public Result addDocument(@RequestBody BookEntity book){
        esService.addDocument(book);
        return Result.success();
    }

}
