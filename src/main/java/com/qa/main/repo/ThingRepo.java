package com.qa.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.main.domain.Thing;

public interface ThingRepo extends JpaRepository<Thing, Long> {

}
