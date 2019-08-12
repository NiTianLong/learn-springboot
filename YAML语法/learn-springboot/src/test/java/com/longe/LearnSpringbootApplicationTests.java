package com.longe;

import com.longe.bean.Person;
import com.longe.bean.Pig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringbootApplicationTests {

	@Autowired
	private Pig pig;

	@Autowired
	private Person person;

	@Test
	public void test001() {
		System.out.println(pig);
	}

	@Test
	public void test002() {
		System.err.println(person);
	}

}
