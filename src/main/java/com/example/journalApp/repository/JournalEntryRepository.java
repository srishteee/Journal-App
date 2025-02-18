package com.example.journalApp.repository;

import com.example.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>  {
}
