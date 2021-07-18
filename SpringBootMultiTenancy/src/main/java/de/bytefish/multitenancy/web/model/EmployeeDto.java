// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.multitenancy.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {

    private final Long id;

    private final String empName;

    private final String empSalary;

    @JsonCreator
    public EmployeeDto(@JsonProperty("id") Long id, @JsonProperty("empName") String empName, @JsonProperty("empSalary") String empSalary) {
        this.id = id;
        this.empName = empName;
        this.empSalary = empSalary;

    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("empName")
    public String getEmpName() {
        return empName;
    }

    @JsonProperty("empSalary")
    public String getEmpSalary() {
        return empSalary;
    }
}