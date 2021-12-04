package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.MachineCreateDto;
import hu.hjst.jobmanager.models.dtos.MachineDto;

import java.util.List;

public class DefaultMachineServiceI implements MachineService {

    @Override
    public MachineDto newMachine(MachineCreateDto dto) {
        //TODO : IMPLEMENTATION
        return null;
    }

    @Override
    public MachineDto findMachinesBySerialNumber(String serialNumber) {
        //TODO : IMPLEMENTATION
        return null;
    }

    @Override
    public List<MachineDto> findMachinesByType(String type) {
        //TODO : IMPLEMENTATION
        return null;
    }

    @Override
    public List<MachineDto> findMachinesByCustomer(String customerName) {
        //TODO : IMPLEMENTATION
        return null;
    }

    @Override
    public List<MachineDto> findAllMachines() {
        //TODO : IMPLEMENTATION
        return null;
    }

    @Override
    public void deleteMachineBySerialNumber(String serialNumber) {
        //TODO : IMPLEMENTATION
    }

    @Override
    public void modifyMachineBySerialNumber(String serialNumber) {
        //TODO : IMPLEMENTATION
    }
}
