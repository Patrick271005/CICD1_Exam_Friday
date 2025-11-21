package Controller;

import Model.Event;
import Service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private final EventService service;
    public EventController(EventService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    @PostMapping
    public ResponseEntity<Event> create(@Valid @RequestBody Event e){
        Event created =  service.create(e);
        return ResponseEntity.created(URI.create("/api/event"+created.getAttendeeName())).body(created);
    }
}
