package com.niriakees.niriakees_api.service;

import com.niriakees.niriakees_api.modele.News;
import com.niriakees.niriakees_api.repository.NewsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News getById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    public News save(News news) {
        return newsRepository.save(news);
    }

    public void delete(Long id) {
        newsRepository.deleteById(id);
    }
}
