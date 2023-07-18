package com.admin.medical.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String orderType;
    private String orderQuan;
    private String orderReason;
    private String orderUser;
    private String orderDate;
    private String orderMedicineId;
}
