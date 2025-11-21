package Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    @NotBlank
    private String attendeeName;
    @Email
    private String email;
    @Pattern(regexp="TK-[0-9]{4}")
    private String ticketCode;
    @Positive
    private int quantity;
}
