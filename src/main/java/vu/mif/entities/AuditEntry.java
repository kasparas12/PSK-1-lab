package vu.mif.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "AUDIT_LOG")
@EqualsAndHashCode(of={"method", "timestamp"})
public class AuditEntry implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String method;

        private Date timestamp;

        @Version
        @Column(name = "OPT_LOCK_VERSION")
        private Integer version;
}
