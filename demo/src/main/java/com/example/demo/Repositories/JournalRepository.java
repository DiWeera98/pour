package com.example.demo.Repositories;

import com.example.demo.Models.Journal;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepository extends CrudRepository<Journal, String> {
    Journal findAllByUser_id(String id);
}
