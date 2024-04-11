package com.example.calendarkursach.controllers;

import com.example.calendarkursach.models.Note;
import com.example.calendarkursach.services.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> getNote(@PathVariable Long id){
        return ResponseEntity.status(201).body(noteService.getNote(id));
    }



}
