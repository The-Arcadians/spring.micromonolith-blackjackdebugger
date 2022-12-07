package com.github.curriculeon.repository;

import com.github.curriculeon.model.Winner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinnerRepository extends CrudRepository<Winner, Long> {
}
