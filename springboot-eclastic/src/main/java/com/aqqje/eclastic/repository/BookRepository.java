package com.aqqje.eclastic.repository;

import com.aqqje.eclastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
}
