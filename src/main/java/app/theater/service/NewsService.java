package app.theater.service;

import app.theater.model.News;
import app.theater.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<News> findAll() {
        return newsRepository.findAll();
    }

    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }

    public List<News> findByHighlighted(Boolean highlighted) {
        return newsRepository.findByHighlighted(highlighted);
    }

    public Integer countHighlightedNews() {
        return newsRepository.countByHighlighted(true);
    }

    public Boolean isAddable() {
        boolean isAddable = (countHighlightedNews() < 5);
        return isAddable ? true : false;
    }

    public Boolean saveNews(News news) {
        if(news.getHighlighted() == true && isAddable() == false) {
            return false;
        }
        news.setDate(new Date());
        newsRepository.save(news);
        return true;
    }

    public News toggleHighlight(News news) {
        if (news.getHighlighted() == true) {
            news.setHighlighted(false);
        } else {
            news.setHighlighted(true);
        }
        return news;
    }

    public Boolean addHighlight(Long newsId) {
        Optional<News> optionalNews = newsRepository.findById(newsId);
        News news = optionalNews.get();
        if(isAddable() == true) {
            toggleHighlight(news);
            newsRepository.save(news);
            return true;
        }
        return false;
    }

    public void deleteHighlight(Long newsId) {
        Optional<News> optionalNews = newsRepository.findById(newsId);
        News news = optionalNews.get();
        toggleHighlight(news);
        newsRepository.save(news);
    }
}
