package com.dundermiflin.office.client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {
    List<Client> findByName(String name);
    Page<Client> findAll(Sort sort);
}
