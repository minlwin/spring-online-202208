package com.jdc.ledgers.service.test;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Sql("/member/data.sql")
@WithMockUser(username = "admin@gmail.com", authorities = {"Admin"})
@SpringJUnitConfig(locations = "classpath:/database-config.xml")
public class EntryDataServiceTest {

}
