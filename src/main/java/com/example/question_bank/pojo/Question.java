package com.example.question_bank.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Question implements Comparable<Question>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "uid")
    private Unit unit;

    private String detailquestion;
    private String answer;
    private String explanation;
    private double score;
    private int searched;
    private int evatimes;


    @Transient
    private List<PropertyValue> propertyValues;

    @Transient
    private int containHotwords = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getDetailquestion() {
        return detailquestion;
    }

    public void setDetailquestion(String detailquestion) {
        this.detailquestion = detailquestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public int getSearched() {
        return searched;
    }

    public void setSearched(int searched) {
        this.searched = searched;
    }

    public int getEvatimes() {
        return evatimes;
    }

    public void setEvatimes(int evatimes) {
        this.evatimes = evatimes;
    }

    public int getContainHotwords() {
        return containHotwords;
    }

    public void setContainHotwords(int containHotwords) {
        this.containHotwords = containHotwords;
    }

    @Override
    public int compareTo(Question o) {
        // TODO Auto-generated method stub
        if(this.containHotwords>=o.containHotwords)
            return -1;//由高到底排序
        else
            return 1;
    }
}
