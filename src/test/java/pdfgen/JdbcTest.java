package pdfgen;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.limame.pdfgen.model.Users;
import com.limame.pdfgen.util.UserRowMapper;

public class JdbcTest {

	ApplicationContext context;
	JdbcTemplate jdbcTemplate;
	
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void getAllUsers(){
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		List<Users> list = jdbcTemplate.query("SELECT * FROM user WHERE login=? AND PASS=?",new UserRowMapper(),"tatou","death");
		for (Users u : list){
			System.out.println(u);
		}
		
	}
	
}
