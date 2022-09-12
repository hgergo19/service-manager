package hu.hjst.jobmanager.models.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class JobCreateDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Boolean isCompleted;
    private Boolean isInvoiced;
    private String invoiceNumber;
    private String note;
    private String serialNumber;
}
