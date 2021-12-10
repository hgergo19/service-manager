package hu.hjst.jobmanager.models.entities;

import hu.hjst.jobmanager.repositories.JobRepository;
import hu.hjst.jobmanager.services.DefaultJobService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
class JobTest {

    @Autowired
    private JobRepository repository;

    @Autowired
    private TestEntityManager manager;


    private Job job1;
    private Job job2;

    @BeforeEach
    void init() {
        job1 = new Job();
        job1.setIsCompleted(false);
        job1.setStartDate(LocalDate.now());
        job1.initFirstId();

        job2 = new Job();
        job1.setStartDate(LocalDate.of(2021,11,17));
    }

    @Test
    @DirtiesContext
    void testAddNewJob() {

        System.out.println("id: " + job1.getJobId());

        manager.persistAndFlush(job1);
        List<Job> jobs = repository.findAll();

        assertEquals(1, jobs.size());
        assertEquals(21001L, jobs.get(0).getJobId());
    }


    @Test
    void generateIdAddOneShouldAddOneToJobNumberIfSameYear() {
        manager.persistAndFlush(job1);
        job2.generateId(21001L);
        manager.persistAndFlush(job2);

        List<Job> jobs = repository.findAll();

        assertEquals(2, jobs.size(),"Size should be 2 after saving both example entities.");
        assertEquals(21001L, jobs.get(0).getJobId(),"Generate first id works as expected");
        assertEquals(21002L, jobs.get(1).getJobId(),"Adds one to job number if same year prefix.");
    }
}