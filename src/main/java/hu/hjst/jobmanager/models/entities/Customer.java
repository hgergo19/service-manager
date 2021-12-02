package hu.hjst.jobmanager.models.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "customers")
@ToString
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

    @OneToMany // TODO config connection!
    @ToString.Exclude
    private List<Machine> machines;
}
