package vu.mif.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.var;
import vu.mif.DTO.EmployeeDTO;
import vu.mif.entities.Employee;
import vu.mif.persistence.EmployeesDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/employees")
public class EmployeesController {

    @Inject
    @Setter @Getter
    private EmployeesDAO employeesDAO;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() {
        List<Employee> emps = employeesDAO.loadAll();
        List<EmployeeDTO> empsDto = new ArrayList<>();

        for (Employee emp : emps
             ) {
            EmployeeDTO empDTO = new EmployeeDTO();
            empDTO.setFirstName(emp.getFirstName());
            empDTO.setLastName(emp.getLastName());
            empDTO.setSalary(emp.getSalary());
            empsDto.add(empDTO);
        }

        return Response.ok(empsDto).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(@PathParam("id") final Integer id) {
        Employee emp = employeesDAO.getById(id);
        if (emp == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setFirstName(emp.getFirstName());
        empDTO.setLastName(emp.getLastName());
        empDTO.setSalary(emp.getSalary());

        return Response.ok(empDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateEmployee(
            @PathParam("id") final Integer employeeId,
            EmployeeDTO employeeData) {
        try {
            Employee emp = employeesDAO.getById(employeeId);
            if (emp == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            if (employeeData.getFirstName() != null) {
                emp.setFirstName(employeeData.getFirstName());
            }
            if (employeeData.getLastName() != null) {
                emp.setLastName(employeeData.getLastName());
            }
            if (employeeData.getSalary() != null) {
                emp.setSalary(employeeData.getSalary());
            }

            employeesDAO.merge(emp);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createEmployee(
            EmployeeDTO emp) {
        try {
            if (emp == null || emp.getFirstName() == null || emp.getLastName() == null || emp.getSalary() == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            Employee empToCreate = new Employee();
            empToCreate.setFirstName(emp.getFirstName());
            empToCreate.setLastName(emp.getLastName());
            empToCreate.setSalary(emp.getSalary());
            employeesDAO.persist(empToCreate);
            return Response.status(Response.Status.CREATED).build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
