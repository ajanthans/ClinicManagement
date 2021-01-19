package com.nets.patientvisit.patientvisit;

import com.nets.patientvisit.patientvisit.model.HolidayEntity;
import com.nets.patientvisit.patientvisit.repo.HolidayRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class PatientvisitApplication implements CommandLineRunner {

    private final HolidayRepo holidayRepo;

    public PatientvisitApplication(HolidayRepo holidayRepo) {
        this.holidayRepo = holidayRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatientvisitApplication.class, args);
    }

    @Override
    public void run(String... args) {
        holidayRepo.saveAll(List.of(
                new HolidayEntity("New Year", LocalDate.of(2021, Month.JANUARY, 1)),
                new HolidayEntity("Chinese New Year", LocalDate.of(2021, Month.JANUARY, 20)),
                new HolidayEntity("Hindu New Year", LocalDate.of(2021, Month.APRIL, 14))
        ));
    }
}
