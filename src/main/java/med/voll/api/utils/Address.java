package med.voll.api.utils;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String neighborhood;
    private String complement;
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;
    @NotBlank
    private String city;
    @NotBlank
    private String state;


}
