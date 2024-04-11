package com.example.calendarkursach.repositories;

import com.example.calendarkursach.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface NoteDBS extends JpaRepository<Note, Long> {
}
