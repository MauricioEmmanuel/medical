package com.admin.medical.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.admin.medical.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>  {
    List<Order> findByOrderMedicineId(String orderMedicineId);
}
