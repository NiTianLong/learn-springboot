package com.longe;

import com.longe.common.MailManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringbootApplicationTests {

	@Autowired
	private MailManager mailManager;

	@Test
	public void test() throws SQLException {

		mailManager.sendTextMail("测试text", "20190804...");
	}

	@Test
	public void testHtml() throws SQLException {

		mailManager.sendHtmlMail("测试html");
	}

	@Test
	public void testAttachment() throws SQLException {

		mailManager.sendAttachmentMail("测试附件");
	}

	@Test
	public void testInline() throws SQLException {

		mailManager.sendInlineMail("测试附件");
	}

	@Test
	public void testThymeleaf() throws SQLException {

		mailManager.sendThymeleafMail("测试Thymeleaf模板");
	}
}
