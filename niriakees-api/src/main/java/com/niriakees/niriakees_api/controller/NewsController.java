package com.niriakees.niriakees_api.controller;

import com.niriakees.niriakees_api.modele.News;
import com.niriakees.niriakees_api.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getAll() {
        return newsService.getAll();
    }

    @GetMapping("/{id}")
    public News getById(@PathVariable Long id) {
        News news = newsService.getById(id);
        if (news == null) {
            throw new RuntimeException("News non trouvée avec l'ID : " + id);
        }
        return news;
    }

    @PostMapping
    public News create(@RequestBody News news) {
        return newsService.save(news);
    }

    @PutMapping("/{id}")
    public News update(@PathVariable Long id, @RequestBody News newsDetails) {
        News news = newsService.getById(id);
        if (news == null) {
            throw new RuntimeException("News non trouvée avec l'ID : " + id);
        }
        news.setTitre(newsDetails.getTitre());
        news.setContenu(newsDetails.getContenu());
        news.setImageUrl(newsDetails.getImageUrl());
        return newsService.save(news);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        newsService.delete(id);
    }
}
