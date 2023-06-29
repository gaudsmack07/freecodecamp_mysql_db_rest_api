package com.dundermiflin.office.branch;

import com.dundermiflin.office.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    private BranchService branchService;

    @RequestMapping("/branches")
    public List<Branch> getAllBranches(){
        return branchService.getAllBranches();
    }

    @RequestMapping("/branches/{id}/manager")
    public Employee getManager(@PathVariable Integer id){
        return branchService.getManager(id);
    }

    @RequestMapping("/branches/{id}/employees")
    public List<Employee> getAllEmployeesAtBranch(@PathVariable Integer id,
                                                  @RequestParam(defaultValue = "0") Integer page,
                                                  @RequestParam(required = false) Integer size,
                                                  @RequestParam(required = false) String sort){
        return branchService.getAllEmployees(id);
    }
}
