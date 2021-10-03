package hu.hjst.jobmanager.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String companyName;
  private String contactPersonName;
  private String primaryEmail;
  private String secondaryEmail;
  private String address;
  private String vatNumber;
  private String accountNumber;
  private String note;
}
