package com.demo.microservice.eventservice.controller;

import com.demo.microservice.eventservice.entity.EmployeeEvent;
import com.demo.microservice.eventservice.repository.EmployeeEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("employee-event")
public class EmployeeEventRestController {

    @Autowired
    EmployeeEventRepository employeeEventRepository;

    @GetMapping(path = "{employeeId}")
    public ResponseEntity<List<String>> getAllEmployeeEventsOfEmployee(@PathVariable String employeeId) {
        List<String> employeeEventOpList = new ArrayList<>();
        List<EmployeeEvent> employeeEventList = employeeEventRepository.findByEmployeeIdOrderByIdAsc(employeeId);
        if(!Objects.isNull(employeeEventList) && !employeeEventList.isEmpty()){
            employeeEventOpList = employeeEventRepository.findByEmployeeIdOrderByIdAsc(employeeId).stream().map(employeeEvent -> employeeEvent.getOpType().name()).collect(Collectors.toList());
        }

        return new ResponseEntity<>(employeeEventOpList, HttpStatus.OK);
    }
}
