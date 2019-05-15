package vu.mif.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class EmployeeDTO {
    public String firstName;
    public String lastName;
    public BigDecimal salary;
}
