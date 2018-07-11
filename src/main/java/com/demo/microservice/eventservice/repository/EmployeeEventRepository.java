package com.demo.microservice.eventservice.repository;

import com.demo.microservice.eventservice.entity.EmployeeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeEventRepository extends JpaRepository<EmployeeEvent, Long> {

    List<EmployeeEvent> findByEmployeeIdOrderByIdAsc(String employeeId);
}
