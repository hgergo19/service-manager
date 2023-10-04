package hu.hjst.jobmanager.models.entities;

import hu.hjst.jobmanager.models.enums.Status;
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

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "invoiced")
    private Boolean isInvoiced;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "serial_number")
    private Machine machine;


    public void initFirstId() {
        String yearPreFix = getYearPreFix();

        String firstString = yearPreFix + "001";
        this.jobId = Long.parseLong(firstString);
    }


    public void generateId(Long lastId) {
        //check if currentYear
        String lastYear = lastId.toString().substring(0, 2);
        String currentYear = getYearPreFix();
        if (lastYear.equals(currentYear)) {
            //add if same

            this.jobId = lastId + 1;
        } else {
            //call initFirst if not
            initFirstId();
        }
    }

    private String getYearPreFix() {
        int year = LocalDate.now().getYear();
        String yearString = Integer.toString(year);
        return yearString.substring(2);
    }
}
