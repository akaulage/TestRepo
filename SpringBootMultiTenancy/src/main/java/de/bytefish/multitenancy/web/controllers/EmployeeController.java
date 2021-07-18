// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.multitenancy.web.controllers;

import de.bytefish.multitenancy.model.Customer;
import de.bytefish.multitenancy.model.Employee;
import de.bytefish.multitenancy.repositories.ICustomerRepository;
import de.bytefish.multitenancy.repositories.IEmployeeRepository;
import de.bytefish.multitenancy.web.converter.Converters2;
import de.bytefish.multitenancy.web.model.CustomerDto;
import de.bytefish.multitenancy.web.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class EmployeeController {

    private final IEmployeeRepository repository;

    @Autowired
    public EmployeeController(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAll() {
        Iterable<Employee> employees = repository.findAll();

        return Converters2.convert(employees);
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto get(@PathVariable("id") long id) {
        Employee employee = repository
                .findById(id)
                .orElse(null);

        return Converters2.convert(employee);
    }

    @GetMapping("/async/employees")
    public List<EmployeeDto> getAllAsync() throws ExecutionException, InterruptedException {
        return repository.findAllAsync()
                .thenApply(x -> Converters2.convert(x))
                .get();
    }

    @PostMapping("/employees")
    public EmployeeDto post(@RequestBody EmployeeDto employee) {
        // Convert to the Domain Object:
        Employee source = Converters2.convert(employee);

        // Store the Entity:
        Employee result = repository.save(source);

        // Return the DTO:
        return Converters2.convert(result);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

}
