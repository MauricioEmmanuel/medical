package com.admin.medical.service;

import java.util.List;
import com.admin.medical.model.Medicine;
import com.admin.medical.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicineServiceImpl implements MedicineService {
    
    @Autowired
    private MedicineRepository medicalRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Medicine> getMedicineList() {
        return (List<Medicine>) medicalRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Medicine getMedicineByID(Long medicineID) {
        return (Medicine) medicalRepository.findById(medicineID).orElse(null);
    }

    @Override
    @Transactional
    public void saveMedicine(Medicine medicine) {
        medicalRepository.save(medicine);
    }
}
