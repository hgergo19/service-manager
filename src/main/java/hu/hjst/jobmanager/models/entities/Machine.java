package hu.hjst.jobmanager.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "machines")
public class Machine {

    @Id
    @Column (length = 20 , nullable = false, unique=true)
    private String serialNumber;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "control", length = 20)
    private String controlType;

    @Column(name = "machine_hours")
    private Integer machineHours;

    @Column(name = "spindle_hours")
    private Integer spindle_hours;

    @Column(name = "nc_software_version", length = 15)
    private String NCsoftwareVersion;

    @Column(name = "plc_software_version", length = 15)
    private String PLCsoftwareVersion;

    @ManyToOne //TODO cascade style ?
    private Customer customer;

    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    @PrePersist
    private void setCreationTime() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void setModificationDate() {
        lastUpdatedAt = LocalDateTime.now();
    }
}
