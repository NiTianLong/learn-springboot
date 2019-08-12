package com.longe.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MailConfig {

    @Value("${spring.mail.username}")
    private String from;//发件人

    @Value("${spring.mail.receives}")
    private String[] to;//收件人

}
