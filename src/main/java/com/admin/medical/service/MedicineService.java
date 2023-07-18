package com.admin.medical.service;

import java.util.List;
import com.admin.medical.model.Medicine;

public interface MedicineService {

    public List<Medicine> getMedicineList();

    public Medicine getMedicineByID(Long medicineID);
    
    public void saveMedicine(Medicine medicine);
}
