package ru.suleymanovtat.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String descriptions;
    private Integer numberOfViews;

    public Post() {
    }

    public Post(Long id, String title, String descriptions, Integer numberOfViews) {
        this.id = id;
        this.title = title;
        this.descriptions = descriptions;
        this.numberOfViews = numberOfViews;
    }

    public Post(String title, String descriptions) {
        this.title = title;
        this.descriptions = descriptions;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Integer getNumberOfViews() {
        return numberOfViews;
    }

    public void setNumberOfViews(Integer numberOfViews) {
        this.numberOfViews = numberOfViews;
    }
}
