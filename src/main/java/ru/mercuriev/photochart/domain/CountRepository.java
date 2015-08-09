package ru.mercuriev.photochart.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CountRepository extends JpaRepository<Count, Long> {

    public Count findByTimestamp(LocalDate timestamp);

}
