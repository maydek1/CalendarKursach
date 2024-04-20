package com.example.calendarkursach.services;

import com.example.calendarkursach.models.Note;
import com.example.calendarkursach.repositories.NoteDBS;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteDBS noteDBS;

    public Optional<Note> getNote(Long id) {
        return noteDBS.findById(id);
    }

    public HttpStatus createNote(Note note){
        System.out.println(note);
        noteDBS.save(note);
        return HttpStatus.CREATED;
    }
}
