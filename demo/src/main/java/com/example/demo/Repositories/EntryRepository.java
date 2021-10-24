package com.example.demo.Repositories;

import com.example.demo.Models.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, String> {
    Entry findAllByJournal_id(String id);
}
