package vu.mif.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name="Employee.findAll", query = "select a from Employee as a"),
        @NamedQuery(name="Employee.findByFullName", query = "select a from Employee as a WHERE CONCAT(a.firstName, ' ', a.lastName) = :fullName")
})
@Table(name = "EMPLOYEE")
@Getter @Setter
@EqualsAndHashCode(of={"firstName", "lastName"})
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="Salary")
    private BigDecimal salary;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @ManyToMany(mappedBy = "employeeList", fetch = FetchType.EAGER)
    private Set<Project> projectList = new HashSet<>();

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
