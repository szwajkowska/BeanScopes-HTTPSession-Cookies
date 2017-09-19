package pl.ania.notes.program.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ania.notes.program.NoteService;

@RestController
@RequestMapping(path = "/notes")
class Controller {

    private final NoteService noteService;

    Controller(NoteService noteService){
        this.noteService = noteService;
    }

//    @GetMapping
//    List<Note> showList(){
//        return noteService.getList();
//    }
//
//    @PostMapping
//    ResponseEntity<Void> addNote(@RequestBody NoteRequest noteRequest){
//        long id = noteService.save(noteRequest);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(URI.create("/notes/" + id));
//        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
//        //lub: return ResponseEntity.created(URI.create("/notes/" + id)).build();
//
//    }
//
//    @GetMapping(path = "/{id}")
//    ResponseEntity<Note> showNoteById(@PathVariable Long id){
//        Note note = noteService.findNoteById(id);
//        if (note == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(note, HttpStatus.OK);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    void deleteNote(@PathVariable Long id){
//        noteService.delete(id);
//
//    }
//
//    @PutMapping(path = "/{id}")
//    void changeNote(@RequestBody NoteRequest noteRequest, @PathVariable Long id){
//   noteService.update(noteRequest, id);
//
//    }
}















