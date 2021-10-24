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
    public Integer createJournal(@RequestBody Journal journal){
        return journalRepository.save(journal).getId();
    }

    @GetMapping(path = "/all/{id}")
    public Iterable<Journal> getAllJournal(@PathVariable("id") String user){
        return journalRepository.findByUserID(user);
    }

    @PutMapping(path = "/update")
    public Integer updateJournal(@RequestBody Journal journal){
        return journalRepository.save(journal).getId();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteJournal(@PathVariable Integer id){
        journalRepository.deleteById(id);
        return "Journal Deleted";
    }
}
