package hu.hjst.jobmanager.models.dtos;

import hu.hjst.jobmanager.models.entities.Machine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CustomerResponseDto {

    private Long id;
    private String companyName;
    private String contactPersonName;
    private String primaryEmail;
    private String secondaryEmail;
    private String address;
    private String vatNumber;
    private String accountNumber;
    private String note;
    private List<Machine> machines; //TODO convert to DTO
}