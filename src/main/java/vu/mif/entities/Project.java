package vu.mif.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "PROJECT")
@Getter  @Setter
@EqualsAndHashCode(of = "name")
@NamedQueries({
        @NamedQuery(name="Project.findAll", query = "SELECT p from Project p"),
        @NamedQuery(name="Project.findById", query = "SELECT p from Project p WHERE p.id = :id")
})
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Name")
    @Size(max=50)
    private String name;

    @Column(name="StartDate")
    private Date startDate;

    @Column(name="Worth")
    private BigDecimal worth;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Employee_Project", joinColumns = {
            @JoinColumn(name="employee_id", referencedColumnName = "ID")
    }, inverseJoinColumns = {
            @JoinColumn(name="project_id", referencedColumnName = "ID")
    })
    private Set<Employee> employeeList = new HashSet<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private Set<Stage> projectStages;
}
