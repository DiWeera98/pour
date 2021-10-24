package com.example.demo.Repositories;

import com.example.demo.Models.Entry;
import com.example.demo.Models.Journal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JournalRepository extends CrudRepository<Journal, Integer> {
    @Query(value = "SELECT * FROM journal where userid=?1",nativeQuery = true)
    List<Journal> findByUserID(String userId);
}
