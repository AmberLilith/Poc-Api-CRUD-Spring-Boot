package med.voll.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Specialty;
import med.voll.api.models.Doctor;
import med.voll.api.utils.Address;

public record DoctorCreatedDto(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        Address address) {

    public static DoctorCreatedDto doctorToDto(Doctor doctor){
        return new DoctorCreatedDto(
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCrm(),
                doctor.getSpecialty(),
                doctor.getAddress()
        );
    }

}
