package com.natsystem.natsystem.repository;

import com.natsystem.natsystem.entity.Carte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaquetRepository extends CrudRepository<Carte, Long> {
}
