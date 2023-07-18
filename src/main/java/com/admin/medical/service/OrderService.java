package com.admin.medical.service;

import java.util.List;
import com.admin.medical.model.Order;

public interface OrderService {
    public void saveOrder(Order order);
    public List<Order> getOrderByMedicineId(String medicineId);
}
