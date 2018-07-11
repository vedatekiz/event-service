package com.demo.microservice.eventservice.entity;

import com.demo.microservice.eventservice.boundary.OpType;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EmployeeEvent extends AbstractPersistable<Long> {

    @Column
    private String employeeId;

    @Column
    @Enumerated(EnumType.STRING)
    private OpType opType;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date opDate;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public OpType getOpType() {
        return opType;
    }

    public void setOpType(OpType opType) {
        this.opType = opType;
    }

    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }
}
