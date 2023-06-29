package com.dundermiflin.office.client;

import com.dundermiflin.office.branch.Branch;
import com.dundermiflin.office.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    private Integer clientId;
    @Column(name = "clientName")
    private String name;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "branchId")
    private Branch branch;

    @ManyToMany(mappedBy = "clients")
    private List<Employee> employees;
}
