package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.MachineCreateDto;
import hu.hjst.jobmanager.models.dtos.MachineDto;
import hu.hjst.jobmanager.models.entities.Machine;
import hu.hjst.jobmanager.repositories.MachineRepository;
import hu.hjst.jobmanager.utils.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        validate(dto, "Machine object cannot be null!");
        validate(dto.getSerialNumber(), "You must enter a valid machine number!");
        validate(dto.getType(), "You must enter a valid machine type!");
        validate(dto.getCustomer(), "You must enter a valid machine type!");

        return modelMapper.map(repository.save(modelMapper.map(dto, Machine.class)), MachineDto.class);
    }

    @Override
    public MachineDto findMachinesBySerialNumber(String serialNumber) {
        Validator.validate(serialNumber, "Serial number id cannot be null!!");
        Optional<Machine> machine = repository.findById(serialNumber);
        return machine.map(m -> modelMapper.map(m, MachineDto.class))
                .orElseThrow(() -> new IllegalArgumentException("Machine with the serial number "
                        + " " + serialNumber + " does not exists!"));
    }


    @Override
    public List<MachineDto> findMachinesByType(String type) {
        //TODO : IMPLEMENTATION
        return null;
    }

    @Override
    public List<Machine> findMachinesByCustomer(Long customerId) {
        Validator.validate(customerId, "Customer id cannot be null!!");
        return repository.findByCustomerId(customerId.intValue());
    }

    @Override
    public List<MachineDto> findAllMachines() {
        List<Machine> machines = repository.findAll();
        return entityWrapper(machines);
    }

    @Override
    public void deleteMachineBySerialNumber(String serialNumber) {
        //TODO : IMPLEMENTATION
    }

    @Override
    public void modifyMachineBySerialNumber(String serialNumber) {
        //TODO : IMPLEMENTATION
    }

    private List<MachineDto> entityWrapper(List<Machine> machines) {
        List<MachineDto> response = new ArrayList<>();
        for (Machine m : machines) {
            response.add(modelMapper.map(m, MachineDto.class));
        }
        return response;
    }
}
