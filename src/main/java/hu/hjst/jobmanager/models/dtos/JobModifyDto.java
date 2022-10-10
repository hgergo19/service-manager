package hu.hjst.jobmanager.models.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobModifyDto {

    private LocalDate endDate;
    private String status;
    private String invoiceNumber;
    private String note;
}
