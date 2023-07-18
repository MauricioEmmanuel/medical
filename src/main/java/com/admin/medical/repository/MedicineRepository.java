package com.admin.medical.repository;

import org.springframework.data.repository.CrudRepository;
import com.admin.medical.model.Medicine;

public interface MedicineRepository extends CrudRepository<Medicine, Long> {
    
}
