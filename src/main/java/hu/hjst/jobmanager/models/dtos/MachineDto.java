package hu.hjst.jobmanager.models.dtos;

import hu.hjst.jobmanager.models.entities.Customer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MachineDto {

    private String serialNumber;
    private String type;
    private String controlType;
    private Integer machineHours;
    private Integer spindle_hours;
    private String NCsoftwareVersion;
    private String PLCsoftwareVersion;
    private Customer customer;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;
}
