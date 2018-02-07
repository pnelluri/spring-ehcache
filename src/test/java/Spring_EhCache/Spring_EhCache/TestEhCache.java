package Spring_EhCache.Spring_EhCache;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nisum.dao.MovieDaoImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MovieDaoImpl.class)
public class TestEhCache {

	@Autowired
	@Qualifier("mdi")
	MovieDaoImpl obj;
	@Test
	public void testCache() {
			System.out.println(obj.findByDirector("dummy"));
			System.out.println(obj.findByDirector("dummy"));
			System.out.println(obj.findByDirector("dummy"));
	}
	@Test
	public void testCache1() {
			System.out.println("Test");
	}
}
