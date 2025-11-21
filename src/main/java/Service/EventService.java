package Service;

import Model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final List<Event> store = new ArrayList<>();
    public List<Event> findAll() {return new ArrayList<>(store);}
    public Optional<Event> findById(String id) {
        for (Event e : store) {
            if(e.getAttendeeName().equals(id)) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }
    public Event create(Event e) {
       if(findById(e.getTicketCode()).isPresent()) {
          // throw new DuplicateException ("Ticket with "+e.getTicketCode()+"has been sold");
       }
       store.add(e);
       return e;
    }
}
