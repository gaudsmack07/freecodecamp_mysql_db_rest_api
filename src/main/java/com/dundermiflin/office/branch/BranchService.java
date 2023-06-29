package com.dundermiflin.office.branch;

import com.dundermiflin.office.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        List<Branch> branches = new ArrayList<>();
        branchRepository.findAll().forEach(branch -> branches.add(branch));
        return branches;
    }

    public List<Employee> getAllEmployees(Integer id) {
        var branch = branchRepository.findById(id);
        return branch.get().getEmployeeList();
    }

    public Employee getManager(Integer id) {
        return branchRepository.findById(id).get().getManager();
    }
}
