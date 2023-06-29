package com.dundermiflin.office.employee;

import com.dundermiflin.office.branch.Branch;
import com.dundermiflin.office.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    //next logical step is to test out the generated value feature
    @Id
    private Integer empId;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private Character sex;
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "super_id", referencedColumnName = "empId")
    @JsonIgnore
    private Employee supervisor;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "branchId")
    @JsonIgnore
    private Branch branch;

    @ManyToMany
    @JoinTable(name = "works_with", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "empId"), inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "clientId"))
    @JsonIgnore
    private List<Client> clients;

}
