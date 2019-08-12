package com.longe;

import com.longe.common.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringbootApplicationTests {

	@Autowired
	private AsyncTask asyncTask;

	@Test
	public void test() throws Exception {

		asyncTask.doTaskOne();
		asyncTask.doTaskTwo();
		asyncTask.doTaskThree();

		Thread.sleep(20_000);
	}

}
