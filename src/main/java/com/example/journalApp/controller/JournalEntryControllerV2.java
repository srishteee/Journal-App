package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;  // spring make journalentry isntance and we inject it here


    @GetMapping//
    public List<JournalEntry> getAll(){
       return journalEntryService.getAll();

    }
    @PostMapping  // create a resource
      public JournalEntry createEntry(@RequestBody JournalEntry journalEntry){
        journalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntries(journalEntry);
            return journalEntry;

}


@GetMapping("id/{myId}") // i want my id only
public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){

     return journalEntryService.findById(myId).orElse(null); // cant return direct bec its optional to catch null avlues
}


    @DeleteMapping("id/{myId}")
public  boolean deleteEntryById(@PathVariable  ObjectId myId){
  journalEntryService.deleteById(myId  );
return true;
}

// to update
@PutMapping("/id/{id}")
public JournalEntry updateJournalById(@PathVariable ObjectId  id,@RequestBody JournalEntry newEntry ){
    JournalEntry OldjournalEntry1 =journalEntryService.findById(id).orElse(null);
    if(OldjournalEntry1!=null){
     OldjournalEntry1.setTitle(newEntry.getTitle() != null  && newEntry.getTitle().equals("") ? newEntry.getTitle() : OldjournalEntry1.getTitle() );
      OldjournalEntry1.setContent(newEntry.getContent() != null && newEntry.getContent().equals("")? newEntry.getContent(): OldjournalEntry1.getContent());
    }
    journalEntryService.saveEntries(OldjournalEntry1);
    return OldjournalEntry1;

}


}
