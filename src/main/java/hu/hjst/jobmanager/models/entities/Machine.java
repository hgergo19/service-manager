package hu.hjst.jobmanager.models.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "machines")
public class Machine {

    @Id
    @Column(length = 20, nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "control_type", length = 20)
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

    @OneToMany(mappedBy = "machine")
    @ToString.Exclude
    private List<Job> jobs;

    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    @PrePersist
    private void setCreationTime() {
        //TODO: check
        if (lastUpdatedAt == null) {
            lastUpdatedAt = LocalDateTime.now();
        }
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void setModificationDate() {
        lastUpdatedAt = LocalDateTime.now();
    }
}
