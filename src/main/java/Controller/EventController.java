package Controller;

import Model.Event;
import Service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    @PutMapping ("/api/event/{id]")
    public ResponseEntity<Event> update(@PathVariable String id, @Valid @RequestBody Event e){
        Optional<Event> maybe = service.findById(e.getTicketCode());
        if(maybe.isPresent()){
            Event updated = maybe.get();
            updated.setAttendeeName(e.getAttendeeName());
            updated.setEmail(e.getEmail());
            return ResponseEntity.ok(updated);


        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/event/{id]")
    public ResponseEntity<Void> delete(@PathVariable String id, @Valid @RequestBody Event e){
        Optional<Event> maybe = service.findById(e.getTicketCode());
        if(maybe.isPresent()){
            //service.deleteBy(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
