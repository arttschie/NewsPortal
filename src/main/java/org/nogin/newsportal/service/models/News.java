package org.nogin.newsportal.service.models;

import java.io.Serializable;

public class News implements Serializable {
    private Long id;
    private String title;
    private String content;
    private User user;

    public News() {
    }

    public News(Long id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        return id.equals(news.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                '}';
    }

    public static NewsBuilder builder() {
        return new NewsBuilder();
    }

    public static class NewsBuilder {
        private Long id;
        private String title;
        private String content;
        private User user;

        public NewsBuilder() {
        }

        public NewsBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public NewsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public NewsBuilder content(String content) {
            this.content = content;
            return this;
        }

        public NewsBuilder user(User user) {
            this.user = user;
            return this;
        }

        public News build() {
            return new News(id, title, content, user);
        }
    }
}
