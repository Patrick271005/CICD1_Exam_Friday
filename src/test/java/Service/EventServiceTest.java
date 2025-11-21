package Service;

import Model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EventServiceTest {
    private EventService service;
    @BeforeEach
    void setUp() {service = new EventService();}
    @Test
    void createthenfindbyticketCode() {
        Event e = Event.builder()
                .attendeeName("Pat")
                .email("pat@ex.com")
                .ticketCode("TK-1234")
                .quantity(1)
                .build();
        service.create(e);
        Optional<Event>found = service.findById("TK-1234");
        assertTrue (found.isPresent());
        assertEquals ("Pat",found.get().getAttendeeName());}
//duplicateTicketCodethrows
    @Test
    void DuplicateException (){
        service.create (Event.builder()
                .attendeeName("john")
                .email("j@ex.com")
                .ticketCode("TK-1235")
                .quantity(1)
                .build());
        assertThrows (IllegalArgumentException.class , () -> service.create(Event.builder()
                .attendeeName("johny")
                .email("jo@ex.com")
                .ticketCode("TK-1235")
                .quantity(1)
                .build()));

    }
    }


