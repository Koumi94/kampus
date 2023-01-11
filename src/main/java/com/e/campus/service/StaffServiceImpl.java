package com.e.campus.service;

import com.e.campus.model.Staff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StaffServiceImpl implements StaffService{
    @Override
    public List<Staff> getAllStaff() {
        return null;
    }

    @Override
    public Optional<Staff> getStaffById(Long id) {
        return Optional.empty();
    }

    @Override
    public Staff addStaff(Staff staff) {
        return null;
    }

    @Override
    public Staff updateStaff(Long id, Staff staff) {
        return null;
    }

    @Override
    public void deleteStaff(Long id) {

    }
}
