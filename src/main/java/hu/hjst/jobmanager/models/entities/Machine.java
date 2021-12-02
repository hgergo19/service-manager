package hu.hjst.jobmanager.models.entities;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "machines") //TODO : create sql DDL script
public class Machine {

    @Id
    @Column (length = 20 , nullable = false, unique=true)
    private String serialNumber;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "control", length = 20)
    private String controlType;

    @Column(name = "machine_hours", length = 6)
    private String machineHours;

    @Column(name = "spindle_hours", length = 6)
    private String spindle_hours;

    @Column(name = "nc_software_version", length = 15)
    private String NCsoftwareVersion;

    @Column(name = "plc_software_version", length = 15)
    private String PLCsoftwareVersion;

    @ManyToOne
    private Customer customer;

    //TODO : machine state ?
    //TODO : last updated and created !
}
