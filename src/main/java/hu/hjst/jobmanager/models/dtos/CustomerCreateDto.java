package hu.hjst.jobmanager.models.dtos;

import lombok.Data;

@Data
public class CustomerCreateDto {

  private String companyName;
  private String contactPersonName;
  private String primaryEmail;
  private String secondaryEmail;
  private String primaryPhoneNumber;
  private String secondaryPhoneNumber;
  private String zipCode;
  private String city;
  private String county;
  private String countryCode;
  private String streetAddress;
  private String postalAddress;
  private String vatNumber;
  private String accountNumber;
}
