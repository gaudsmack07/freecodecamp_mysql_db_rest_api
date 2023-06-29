package com.dundermiflin.office.branch;

import com.dundermiflin.office.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Branch {
    @Id
    private Integer branchId;
    private String branchName;

    @OneToOne
    @JoinColumn(name = "mgr_id", referencedColumnName = "empId")
    @JsonIgnore
    private Employee manager;

    private Date mgrStartDate;

    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employeeList;

}
