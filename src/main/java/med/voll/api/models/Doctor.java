package med.voll.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dtos.DoctorCreatedDto;
import med.voll.api.dtos.DoctorUpdatedDto;
import med.voll.api.enums.Specialty;
import med.voll.api.utils.Address;

@Table(name = "doctors")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;

    public static Doctor createdDtoToDoctor(DoctorCreatedDto dto){
        Doctor doctor = new Doctor();
        doctor.name = dto.name();
        doctor.email = dto.email();
        doctor.crm = dto.crm();
        doctor.specialty = dto.specialty();
        doctor.address = dto.address();
        return doctor;

    }

    public static Doctor updatedDtoToDoctor(DoctorUpdatedDto dto){
        Doctor doctor = new Doctor();
        doctor.name = dto.name();
        doctor.email = dto.email();
        doctor.crm = dto.crm();
        doctor.specialty = dto.specialty();
        return doctor;

    }


}
