package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.MachineCreateDto;
import hu.hjst.jobmanager.models.dtos.MachineDto;
import hu.hjst.jobmanager.repositories.MachineRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

import static hu.hjst.jobmanager.utils.Validator.validate;

public class DefaultMachineService implements MachineService {

    private final ModelMapper modelMapper = new ModelMapper();
    private MachineRepository repository;

    public DefaultMachineService(MachineRepository repository) {
        this.repository = repository;
    }

    @Override
    public MachineDto newMachine(MachineCreateDto dto) {
        //validation
        validate(dto,"Machine object cannot be null!");
        validate(dto.getSerialNumber(),"You must enter a valid machine number!");
        validate(dto.getType(),"You must enter a valid machine type!");
        validate(dto.getCustomer(),"You must enter a valid machine type!");

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
