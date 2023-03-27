package med.voll.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Specialty;
import med.voll.api.models.Doctor;

public record DoctorUpdatedDto(

        @NotNull
        Long id,

        String name,

        @Email
        String email,

        @Pattern(regexp = "\\d{4,6}")
        String crm,

        Specialty specialty
) {

        public static DoctorUpdatedDto doctorToUpdatedDto(Doctor doctor){
                return new DoctorUpdatedDto(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getEmail(),
                        doctor.getCrm(),
                        doctor.getSpecialty()
                );
        }
}
