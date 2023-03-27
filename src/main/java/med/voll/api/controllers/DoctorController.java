package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.DoctorShowDatasDto;
import med.voll.api.dtos.DoctorUpdatedDto;
import med.voll.api.services.DoctorService;
import med.voll.api.dtos.DoctorCreatedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    DoctorService service;

    @PostMapping
    public ResponseEntity<DoctorCreatedDto> save(@RequestBody @Valid DoctorCreatedDto doctorCreatedDto){
        return new ResponseEntity<>(service.save(doctorCreatedDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<DoctorShowDatasDto>> listAll(@PageableDefault(size = 1, sort = {"email"}, direction = Sort.Direction.DESC) Pageable pageable){
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DoctorUpdatedDto> update(@RequestBody @Valid DoctorUpdatedDto doctorUpdatedDto){
        return new ResponseEntity<>(service.update(doctorUpdatedDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}
