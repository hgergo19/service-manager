package hu.hjst.jobmanager.models.dtos;

import hu.hjst.jobmanager.models.entities.Machine;
import hu.hjst.jobmanager.models.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobDto {

    private Long jobId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isCompleted;
    private Status status;
    private Boolean isInvoiced;
    private String invoiceNumber;
    private String note;
    private Machine machine;
}
