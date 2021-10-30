package hu.hjst.jobmanager.models.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerResponseDto {

  private String companyName;
  private String contactPersonName;
  private String primaryEmail;
  private String secondaryEmail;
  private String address;
  private String vatNumber;
  private String accountNumber;
  private String note;
}