package com.example.journalApp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

// pojo class -- plain old java obj  class
// we can use @data instead of getter and setter consturctor , noRGS AND ALLARGS CONTSR WHICH IS A PART OF LOMBOK
@Document(collection="journal_entries") // this is mapped w journal_entries
public class JournalEntry {

    @Id
    private ObjectId id;    // if we cannot provide id then in mongodb data type of id is object id

    private String title;

    private String content;

    private LocalDateTime date ;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getContent() {
        return content;


    }

    public void setContent(String content) {
        this.content = content;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





}
