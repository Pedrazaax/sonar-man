package com.TIComoApp.TIComo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TIComoApp.TIComo.model.Asistente;




public interface AsistenteRepository extends MongoRepository<Asistente,String>{
	Optional<Asistente> findByEmail(String email);
}
