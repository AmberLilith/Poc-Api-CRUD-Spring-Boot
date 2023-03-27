package med.voll.api.services;

import jakarta.transaction.Transactional;
import med.voll.api.dtos.DoctorCreatedDto;
import med.voll.api.dtos.DoctorShowDatasDto;
import med.voll.api.dtos.DoctorUpdatedDto;
import med.voll.api.models.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository repository;
    @Transactional
    public DoctorCreatedDto save(DoctorCreatedDto doctorCreatedDto){
        Doctor doctorRequest = Doctor.createdDtoToDoctor(doctorCreatedDto);
        Doctor doctorReponse = repository.save(doctorRequest);
        return DoctorCreatedDto.doctorToDto(doctorReponse);
    }


    public Page<DoctorShowDatasDto> findAll(Pageable pageable) {
        return DoctorShowDatasDto.doctorToShowDatasDto( repository.findAll(pageable));
    }

    public DoctorUpdatedDto update(DoctorUpdatedDto doctorUpdatedDto) {
        Optional<Doctor> doctor = repository.findById(doctorUpdatedDto.id());
        if(doctor.isPresent()){
            Doctor doctorToUpdate = doctor.get();
            doctorToUpdate.setName(doctorUpdatedDto.name() != null ? doctorUpdatedDto.name(): doctorToUpdate.getName());
            doctorToUpdate.setEmail(doctorUpdatedDto.email() != null ? doctorUpdatedDto.email(): doctorToUpdate.getEmail());
            doctorToUpdate.setCrm(doctorUpdatedDto.crm() != null ? doctorUpdatedDto.crm(): doctorToUpdate.getCrm());
            doctorToUpdate.setSpecialty(doctorUpdatedDto.specialty() != null ? doctorUpdatedDto.specialty(): doctorToUpdate.getSpecialty());
            Doctor doctorReponse = repository.save(doctorToUpdate);
            return DoctorUpdatedDto.doctorToUpdatedDto(doctorReponse);


        }else{
            throw new RuntimeException("Usuário com id " + doctorUpdatedDto.id() + " não existe!");
        }
    }

    public String delete(Long id){
        Optional<Doctor> doctorToDelete = repository.findById(id);

        if(doctorToDelete.isPresent()){
            repository.deleteById(id);
            return "Médico excluído com sucesso!";
        }else{
            throw new RuntimeException("Médico não encontrado com id " + id);
        }


    }
}
