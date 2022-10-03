package hu.hjst.jobmanager.models.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobModifyDto {

    private LocalDate endDate;
    private Boolean isCompleted;
    private String status;
    private Boolean isInvoiced;
    private String invoiceNumber;
    private String note;
}
