package fr.free.omathe.home.model.dao;

import org.springframework.data.repository.CrudRepository;

import fr.free.omathe.home.model.Home;

public interface HomeRepository extends CrudRepository<Home, Long> {
	
}
