// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.multitenancy.model;

import javax.persistence.*;

@Entity
@Table(schema = "test1", name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_salary")
    private String empSalary;

    protected Employee() {
    }

    public Employee(Long id, String empName, String empSalary) {
        this.id = id;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public Long getId() {
        return id;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpSalary() {
        return empSalary;
    }
}

