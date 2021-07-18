// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.multitenancy.repositories;

import de.bytefish.multitenancy.model.Customer;
import de.bytefish.multitenancy.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

    @Async
    @Query("select e from Employee e")
    CompletableFuture<List<Employee>> findAllAsync();

}
