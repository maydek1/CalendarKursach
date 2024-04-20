package com.example.calendarkursach.controllers;

import com.example.calendarkursach.models.Note;
import com.example.calendarkursach.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> getNote(@PathVariable Long id){
        return ResponseEntity.status(201).body(noteService.getNote(id));
    }

    @GetMapping("")
    public String getPage(){
        return "createNote";
    }

    @PostMapping("/create_note")
    public String createNote(@ModelAttribute("createNote") Note noteForm){
        noteService.createNote(noteForm);
        return "redirect:/home";
    }



}
