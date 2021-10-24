package com.example.demo.Controllers;

import com.example.demo.Models.Journal;
import com.example.demo.Models.User;
import com.example.demo.Repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/journal")
public class JournalController {

    @Autowired
    private JournalRepository journalRepository;

    @PostMapping(path = "/add")
    public String createJournal(@RequestBody Journal journal){
        return journalRepository.save(journal).getId();
    }

    @GetMapping(path = "/all")
    public Iterable<Journal> getAllJournal(@RequestBody User user){
        return (Iterable<Journal>) journalRepository.findAllByUser_id(user.getId());
    }

    @PutMapping(path = "/update")
    public String updateJournal(@RequestBody Journal journal){
        return journalRepository.save(journal).getId();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteJournal(@PathVariable String id){
        journalRepository.deleteById(id);
        return "Journal Deleted";
    }
}
