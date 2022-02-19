package hu.hjst.jobmanager.models.entities;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "service_reports")
public class ServiceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String technicianId;  //TODO : --> user entity, select from list and convert to ID in service (manyToMany?)
    private Long jobId; // TODO --> @OneToMany
    private Double workHours;
    private Double travelHours;
    private Integer distanceInKm;
    private Boolean isAccomodation;
    private Long usedMaterialId;
    private String shortErrorDescription;






}
