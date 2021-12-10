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
@Table(name = "jobs")
@ToString
@RequiredArgsConstructor
public class Job {

    @Id
    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "completed")
    private Boolean isCompleted;

    @Column(name = "invoiced")
    private Boolean isInvoiced;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "note")
    private String note;

    @ManyToOne //TODO config relation
    private Machine machine;


    public void generateId() {
        //TODO generation logic same as before 21001L
    }
}
