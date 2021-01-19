package com.nets.patientvisit.patientvisit.services;

import com.nets.patientvisit.patientvisit.exception.HolidayException;
import com.nets.patientvisit.patientvisit.model.HolidayEntity;
import com.nets.patientvisit.patientvisit.repo.HolidayRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HolidayService {

    private final HolidayRepo holidayRepo;

    public HolidayService(HolidayRepo holidayRepo) {
        this.holidayRepo = holidayRepo;
    }

    public void isOnHoliday(LocalDateTime dateTime) {
        LocalDate requestDate = dateTime.toLocalDate();
        List<HolidayEntity> allHolidays = holidayRepo.findAll();
        boolean isHoliday = allHolidays.stream()
                .filter(holidayEntity -> holidayEntity.getHolidayDate().isEqual(requestDate))
                .distinct()
                .findAny().isPresent();

        if (isHoliday) {
            throw new HolidayException("Data modification on Holiday is prohibited");
        }
    }
}
