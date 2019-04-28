package vu.mif.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="STAGE")
@Getter @Setter
@EqualsAndHashCode(of="name")
public class Stage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Name")
    @Size(max=50)
    private String name;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @JoinColumn(name="PROJECT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Project project;
}
