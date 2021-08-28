package hu.hjst.jobmanager.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
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
