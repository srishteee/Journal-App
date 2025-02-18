//package com.example.journalApp.controller;
//
//import com.example.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//// methods inside a controller class should be public so that they can extend and invoked by springframewokr or ext http req
//// it handle http request speacial type of component
//@RestController
//@RequestMapping("/journal") // it adds the mapping to the whole class
//public class JournalEntityController {
//
//    private Map<Long,JournalEntry> journalEntries = new HashMap<>();
////    @GetMapping("/abc") // then poath will be like journal/abc
//    @GetMapping// then poath will be like journal/abc    localhost:8080/journal - GET
//    public List<JournalEntry> getAll(){
//
//    return  new ArrayList<>(journalEntries.values()); // get the values and convert to array list
//        // if i want to acess that method via end point then  ill use getmapping
//    }
//    @PostMapping  // create a resource
//public boolean createEntry(@RequestBody JournalEntry journalEntry){
//        // POST  -- y spring pls take the data rom the reqd turn into java obj so that i can use in my code means dta from postman post here
//        journalEntries.put(journalEntry.getId(),journalEntry); // key and id
//        return true;
//}
//
//// if on postman i send "id?name=rhea" -->the it is requestparam and if i send like "/id/rhea "- then it is path varibale
//@GetMapping("id/{myId}") // i want my id only
//public JournalEntry getJournalEntryById(@PathVariable long myId){
//        // always give the type in path variable
//return journalEntries.get(myId);
//}
//    @DeleteMapping("id/{myId}")
//public JournalEntry deleteEntryById(@PathVariable long  myId){
//
//       return journalEntries.remove(myId);
//}
//@PutMapping("/id/{id}")
//public JournalEntry updateJournalById(@PathVariable long id,@RequestBody JournalEntry journalEntry ){
//
//return   journalEntries.put( id,journalEntry);
//}
//}
