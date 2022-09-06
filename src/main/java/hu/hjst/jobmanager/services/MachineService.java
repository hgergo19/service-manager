package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.MachineCreateDto;
import hu.hjst.jobmanager.models.dtos.MachineDto;
import hu.hjst.jobmanager.models.entities.Machine;

import java.util.List;

public interface MachineService {

    MachineDto newMachine(MachineCreateDto dto);

    MachineDto findMachinesBySerialNumber(String serialNumber);

    List<MachineDto> findMachinesByType(String type);

    List<Machine> findMachinesByCustomer(Long customerId);

    List<MachineDto> findAllMachines();

    void deleteMachineBySerialNumber(String serialNumber);

    void modifyMachineBySerialNumber(String serialNumber);
}
