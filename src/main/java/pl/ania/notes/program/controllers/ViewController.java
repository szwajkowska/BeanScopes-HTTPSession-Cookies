package pl.ania.notes.program.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.ania.notes.program.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/test")
public class ViewController {
    private final NoteService noteService;
    private final UserList userList;

    public ViewController(NoteService noteService, UserList userList) {
        this.noteService = noteService;
        this.userList = userList;
    }

    @GetMapping
    String test(ModelMap model, Principal principal) {
        String name = principal.getName();
//        String name = "bania";
        model.put("notes", noteService.getAll(name));
        return "test";
    }

    @GetMapping("/login")
    String log(){
        return "login";
    }

    @PostMapping
//    String addNote(@RequestBody NoteRequest noteRequest, ModelMap model){
    String addNote(@RequestParam(value = "body") String body, ModelMap model, HttpServletResponse response,
                   Principal principal) {
        String name = principal.getName();
        NoteRequest noteRequest = new NoteRequest(body);
        String id = noteService.save(noteRequest, name);
        response.addHeader("Location", "/test/" + id );
        model.put("notes", noteService.getAll(name));
        return "test";

    }

//    @GetMapping("/a")
//    String showPage(){
//        return "login";
//    }

    @GetMapping(path = "/{id}")
    String showNoteById(@PathVariable String id, ModelMap model, Principal principal) {
        String name = principal.getName();
        Note note = noteService.findNoteById(id);

        if (note == null) {
            return "wrong_id";
        }
        String body = note.getBody();
        model.put("body", body);
        model.put("id", id);
        return "note";
    }

    @PostMapping(path = "/{id}")
    String deleteNote(@PathVariable String id, ModelMap model, Principal principal) {
        String name = principal.getName();
        noteService.delete(id);
        model.put("notes", noteService.getAll(name));
        return "redirect:/test";
    }

    @GetMapping(path = "/signIn")
    String signIn(UserModel userModel){
        return "signIn";
    }


}
