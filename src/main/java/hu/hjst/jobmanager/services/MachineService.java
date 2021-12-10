package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.MachineCreateDto;
import hu.hjst.jobmanager.models.dtos.MachineDto;

import java.util.List;

public interface MachineService {

    MachineDto newMachine(MachineCreateDto dto);

    MachineDto findMachinesBySerialNumber(String serialNumber);

    List<MachineDto> findMachinesByType(String type);

    List<MachineDto> findMachinesByCustomer(String customerName);

    List<MachineDto> findAllMachines();

    void deleteMachineBySerialNumber(String serialNumber);

    void modifyMachineBySerialNumber(String serialNumber);
}
