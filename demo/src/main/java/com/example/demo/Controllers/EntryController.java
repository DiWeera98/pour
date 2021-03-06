package com.example.demo.Controllers;

import com.example.demo.Models.Entry;
import com.example.demo.Models.Journal;
import com.example.demo.Repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/entry")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @PostMapping(path = "/add")
    public Integer createEntry(@RequestBody Entry entry){
        return entryRepository.save(entry).getId();
    }

    @GetMapping(path = "/all/{id}")
    public Iterable<Entry> getAllEntries(@PathVariable("id") Integer journal){
        return (Iterable<Entry>) entryRepository.findByJournalId(journal);
    }
}
