package com.demo.microservice.eventservice.service;

import com.demo.microservice.eventservice.boundary.EmployeeEventDTO;
import com.demo.microservice.eventservice.entity.EmployeeEvent;
import com.demo.microservice.eventservice.repository.EmployeeEventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeOpService {

    @Autowired
    EmployeeEventRepository employeeEventRepository;

    @Autowired
    ObjectMapper objectMapper;

    @RabbitListener(queues = "${rabbit.employeeOpQueue}")
    public void receiveEmployeeOpMessage(EmployeeEventDTO employeeEventDTO) {
        System.out.println("Message Received:" + employeeEventDTO.getEmployeeId() + "-" + employeeEventDTO.getOpType() + " " + employeeEventDTO.getOpDate());
        EmployeeEvent employeeEvent = objectMapper.convertValue(employeeEventDTO, EmployeeEvent.class);
        employeeEventRepository.save(employeeEvent);
    }
}
