package hu.hjst.jobmanager.models.dtos;

import lombok.Data;

@Data
public class CustomerCreateDto {

  private String companyName;
  private String contactPersonName;
  private String primaryEmail;
  private String secondaryEmail;
  private String address;
  private String vatNumber;
  private String accountNumber;
  private String note;
}
