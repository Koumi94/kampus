package com.e.campus.api;

import com.e.campus.model.Ogrenci;
import com.e.campus.model.Staff;

import com.e.campus.repository.StaffRepository;
import com.e.campus.service.StaffService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    private final StaffRepository staffRepository;

    public StaffController(StaffService staffService, StaffRepository staffRepository) {
        this.staffService = staffService;
        this.staffRepository = staffRepository;
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/staff/{id}")
    public Optional<Staff> getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @PostMapping("/addstaff")
    public Staff addOgrenci(@RequestBody Staff staff ) {
        return  staffService.addStaff(staff);
    }

    @PutMapping("/staff/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        try {
            staff.setId(id);
            Staff updatedStaff = staffRepository.save(staff);
            return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/staff/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        try {
            staffRepository.deleteById(id);
            return new ResponseEntity<>("Staff başarıyla silindi.", HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Staff bulunamadı.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Staff silinirken hata oluştu.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
