package com.example.calendarkursach.services;

import com.example.calendarkursach.models.Note;
import com.example.calendarkursach.repositories.NoteDBS;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteService {
    private NoteDBS noteDBS;

    public Optional<Note> getNote(Long id) {
        return noteDBS.findById(id);
    }
}
