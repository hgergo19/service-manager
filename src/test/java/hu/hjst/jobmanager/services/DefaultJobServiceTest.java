package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.repositories.JobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultJobServiceTest {

    @Mock
    private JobRepository repository;

    @Mock
    private CustomerService customerService;

    @Mock
    private MachineService machineService;

    @InjectMocks
    private DefaultJobService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void newJob() {
    }

    @Test
    void findJobByJobId() {
    }

    @Test
    void findJobsByStatus() {
    }

    @Test
    void findJobsByMachineNumber() {
    }

    @Test
    void findJobsByCustomer() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findActiveJobs() {
    }

    @Test
    void deleteJobById() {
    }

    @Test
    void modifyJobById() {
    }
}