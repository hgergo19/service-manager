package hu.hjst.jobmanager.models.dtos;

import hu.hjst.jobmanager.models.entities.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
//TODO ? equals & hashCode necessary?
public class MachineCreateDto {

    private String serialNumber;
    private String type;
    private String controlType;
    private Integer machineHours;
    private Integer spindle_hours;
    private String NCsoftwareVersion;
    private String PLCsoftwareVersion;
    private Customer customer;
}
