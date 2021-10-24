package com.example.demo.Repositories;

import com.example.demo.Models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, String> {
    @Query(value = "SELECT * FROM entry where journal_id=?1",nativeQuery = true)
    List<Entry> findByJournalId(Integer journalId);

//    Entry findAllByJournalId(String id);

}
