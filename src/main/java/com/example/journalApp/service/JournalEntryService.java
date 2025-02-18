package com.example.journalApp.service;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;  // at runtime spring generates the interface implemetation on variable " journalEntryRepository"

    public void saveEntries(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    // for GET

    public List<JournalEntry> getAll(){
        return  journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id); // del is not return anything
    }

}
