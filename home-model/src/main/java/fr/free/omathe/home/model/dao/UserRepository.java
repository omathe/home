package fr.free.omathe.home.model.dao;

import fr.free.omathe.home.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByEmail(String email);
}
