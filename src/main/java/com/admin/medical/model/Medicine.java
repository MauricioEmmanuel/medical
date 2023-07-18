package com.admin.medical.model;

import java.io.Serializable;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicine")
public class Medicine implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;
    private String medicineDesc;
    private String medicineBatch;
    private String medicineExpDate;
    private String medicineRegDate;
}
