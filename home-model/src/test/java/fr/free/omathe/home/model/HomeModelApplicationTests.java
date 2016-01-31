package fr.free.omathe.home.model;

import fr.free.omathe.home.model.dao.HomeRepository;
import fr.free.omathe.home.model.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HomeModelApplication.class)
public class HomeModelApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HomeRepository homeRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createUser() {
        User user = new User("Olivier", "MATHE", "omathe2@free.fr", "oma", "pwd");
        userRepository.save(user);
    }

    @Test
    public void createHome() {
        Home home = new Home();
        home.setName("domaine");
        homeRepository.save(home);
    }

//	@Test
//	public void addUserHome() {
//		
//		User user = userRepository.findOne(Long.valueOf(1));
//		System.out.println("user = " + user);
//		//Home home = homeRepository.findOne(Long.valueOf(1));
//		//System.out.println("user = " + user);
//		Home home = new Home();
//		home.setName("domaine");
//		user.addHome(home);
//		userRepository.save(user);
//	}
//	@Test
//	public void createPojo() {
//		PojoDao pojoDao = new PojoDao();
//		pojoDao.setName("Pojo 1");
//		pojoRepository.save(pojoDao);
//	}
    
}
