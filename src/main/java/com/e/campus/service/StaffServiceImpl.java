package com.e.campus.service;

import com.e.campus.model.Staff;
import com.e.campus.repository.IkRepository;
import com.e.campus.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StaffServiceImpl implements StaffService{
    private  final StaffRepository staffRepository;



    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(Long id, Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(Long id) {

    }
}
