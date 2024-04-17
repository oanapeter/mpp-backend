package net.javaguides.mpp;


import net.javaguides.mpp.tests.CatTest;
import net.javaguides.mpp.tests.RepoTest;
import net.javaguides.mpp.tests.ServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MppBackendApplicationTests {

	@Autowired
	private CatTest catTest;
	private RepoTest repoTest;
	private ServiceTest serviceTest;

	@Test
	void testCat(){
		catTest.testCat();
	}

	@Test
	void testRepo(){
		repoTest.allTests();
	}

	@Test
	void testService(){
		serviceTest = new ServiceTest();
		serviceTest.allTests();
	}

}
