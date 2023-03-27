package med.voll.api.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import med.voll.api.enums.Specialty;
import med.voll.api.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public record DoctorShowDatasDto(

        Long id,
        String name,
        String email,
        String crm,
        @Enumerated(EnumType.STRING)
        Specialty specialty
) {

    public DoctorShowDatasDto(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }

    public static Page<DoctorShowDatasDto> doctorToShowDatasDto(Page<Doctor> doctors){
       return  doctors.map(DoctorShowDatasDto::new);

    }
}
