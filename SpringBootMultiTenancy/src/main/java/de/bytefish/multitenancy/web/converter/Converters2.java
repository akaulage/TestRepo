// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.multitenancy.web.converter;

import de.bytefish.multitenancy.model.Customer;
import de.bytefish.multitenancy.model.Employee;
import de.bytefish.multitenancy.web.model.CustomerDto;
import de.bytefish.multitenancy.web.model.EmployeeDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Converters2 {

    private Converters2() {

    }

    public static EmployeeDto convert(Employee source) {
        if (source == null) {
            return null;
        }

        return new EmployeeDto(source.getId(), source.getEmpName(), source.getEmpSalary());
    }

    public static Employee convert(EmployeeDto source) {
        if (source == null) {
            return null;
        }

        return new Employee(source.getId(), source.getEmpName(), source.getEmpSalary());
    }

    public static List<EmployeeDto> convert(Iterable<Employee> employees) {
        return StreamSupport.stream(employees.spliterator(), false)
                .map(Converters2::convert)
                .collect(Collectors.toList());
    }
}
