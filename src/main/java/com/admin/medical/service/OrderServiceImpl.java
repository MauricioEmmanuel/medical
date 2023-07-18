package com.admin.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.medical.model.Order;
import com.admin.medical.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrderByMedicineId(String medicineId) {
        return (List<Order>) orderRepository.findByOrderMedicineId(medicineId);
    }
}
