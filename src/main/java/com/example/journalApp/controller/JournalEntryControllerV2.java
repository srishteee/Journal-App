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
import java.util.Optional;

@RestController
@RequestMapping("journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;  // spring make journalentry isntance and we inject it here


    @GetMapping//
    public ResponseEntity<?>getAll(){
        List<JournalEntry> all = journalEntryService.getAll();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping  // create a resource
      public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry){

        try {
            journalEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntries(journalEntry);
            return new ResponseEntity<>(journalEntry,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST );
        }

}


@GetMapping("id/{myId}") // i want my id only
public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId) {
    Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
    if(journalEntry.isPresent()){
        return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}


    @DeleteMapping("id/{myId}")
public ResponseEntity<?> deleteEntryById(@PathVariable  ObjectId myId){
  journalEntryService.deleteById(myId  );
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

// to update
@PutMapping("/id/{id}")
public ResponseEntity<?> updateJournalById(@PathVariable ObjectId  id,@RequestBody JournalEntry newEntry ){
    JournalEntry OldjournalEntry1 =journalEntryService.findById(id).orElse(null);
    if(OldjournalEntry1!=null){
     OldjournalEntry1.setTitle(newEntry.getTitle() != null  && newEntry.getTitle().equals("") ? newEntry.getTitle() : OldjournalEntry1.getTitle() );
      OldjournalEntry1.setContent(newEntry.getContent() != null && newEntry.getContent().equals("")? newEntry.getContent(): OldjournalEntry1.getContent());
        journalEntryService.saveEntries(OldjournalEntry1);
        return new ResponseEntity<>(OldjournalEntry1, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
}
