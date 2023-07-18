/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.admin.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.admin.medical.model.Medicine;
import com.admin.medical.model.Order;
import com.admin.medical.model.User;
import com.admin.medical.model.UserReq;
import com.admin.medical.service.MedicineService;
import com.admin.medical.service.OrderService;
import com.admin.medical.service.UserService;

/**
 *
 * @author Mauricio
 */
@Controller
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MedicineService medicineService;

    @Autowired
    OrderService orderService;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserReq userReq) {
        User userData = userService.getUser(userReq.getUserName(), userReq.getUserPass());
        com.google.gson.Gson gson = new com.google.gson.Gson();
        String json = gson.toJson(userData);
        if (userData != null) {
            return ResponseEntity.status(HttpStatus.OK).body(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Verifica tu usuario y contraseña");
        }
    }

    @GetMapping("/medicineList")
    public ResponseEntity<Object> getMedicineList() {
        List<Medicine> medicineList = medicineService.getMedicineList();
        com.google.gson.Gson gson = new com.google.gson.Gson();
        String json = gson.toJson(medicineList);
        if (medicineList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tabla de Medicinas sin datos");
        }
    }

    @GetMapping("/getMedicineByID/{medicineID}")
    public ResponseEntity<Object> getMedicineByID(@PathVariable Long medicineID) {
        Medicine medicineData = medicineService.getMedicineByID(medicineID);
        com.google.gson.Gson gson = new com.google.gson.Gson();
        String json = gson.toJson(medicineData);
        if (medicineData != null) {
            return ResponseEntity.status(HttpStatus.OK).body(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el medicamento");
        }
    }

    @PostMapping("/saveMedicine")
    public ResponseEntity<Object> saveMedicine(@RequestBody Medicine medicine) {
        try {
            medicineService.saveMedicine(medicine);
            return ResponseEntity.status(HttpStatus.OK).body("Datos insertados con exito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al insertar: " + e);
        }
    }

    @PostMapping("/saveOrder")
    public ResponseEntity<Object> saveOrder(@RequestBody Order order) {
        try {
           orderService.saveOrder(order); 
           return ResponseEntity.status(HttpStatus.OK).body("Datos insertados con exito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al insertar: " + e);
        }
    }

    @GetMapping("/getOrderListByMedicineId/{medicineId}")
    public ResponseEntity<Object> getOrderListByMedicineId(@PathVariable String medicineId) {
        List<Order> orderList = orderService.getOrderByMedicineId(medicineId);
        com.google.gson.Gson gson = new com.google.gson.Gson();
        String json = gson.toJson(orderList);
        if (orderList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al recuperar lista de ordenes");
        }
    }
}
