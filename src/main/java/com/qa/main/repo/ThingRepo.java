package com.qa.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.qa.main.domain.Thing;


@Repository
public interface ThingRepo extends JpaRepository<Thing, Long> {

}
