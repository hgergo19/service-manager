package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.MachineCreateDto;
import hu.hjst.jobmanager.models.dtos.MachineDto;
import hu.hjst.jobmanager.models.entities.Machine;
import hu.hjst.jobmanager.repositories.MachineRepository;
import hu.hjst.jobmanager.utils.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static hu.hjst.jobmanager.utils.Validator.validate;

@Service
public class DefaultMachineService implements MachineService {

    private final ModelMapper modelMapper = new ModelMapper();
    private final MachineRepository repository;
    private final CustomerService customerService;

    public DefaultMachineService(MachineRepository repository, CustomerService customerService) {
        this.repository = repository;
        this.customerService = customerService;
    }

    @Override
    public MachineDto newMachine(MachineCreateDto dto) {
        //validation
        validate(dto,"Machine object cannot be null!");
        validate(dto.getSerialNumber(),"You must enter a valid machine number!");
        validate(dto.getType(),"You must enter a valid machine type!");
        validate(dto.getCustomer(),"You must enter a valid machine type!");

        return modelMapper.map(repository.save(modelMapper.map(dto, Machine.class)),MachineDto.class);
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
    public List<Machine> findMachinesByCustomer(Long customerId) {
        Validator.validate(customerId,"Customer id cannot be null!!");
        List<Machine> allByCustomerId = repository.findByCustomerId(customerId.intValue());
        return allByCustomerId;
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
