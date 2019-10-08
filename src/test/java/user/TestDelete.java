package user;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import controllers.ControllerUser;
import exceptions.AdminException;
import exceptions.UserNotFoundException;
import model.bean.User;

public class TestDelete {
	
	private User user1;
	private User user2;
	private User admin;
	private ControllerUser conuser; 
	
	@Before
	public void setUp(){
		user1 = new User("Gilberto", "Padawan", "hello", 0, false);
		user2 = new User("Bruno", "Padawan2", "hello2", 0, false);
		admin = new User("Thiago", "ObiWan", "hello@", 0, true);
		conuser = new ControllerUser();
	}
	
	/**
	 * Teste para deletar o usuario com um administrador
	 * @throws SQLException
	 * @throws UserNotFoundException
	 * @throws AdminException 
	 */
	@Test
	public void testDeleteAdm() throws SQLException, UserNotFoundException, AdminException {
		conuser.create(user1, admin);
		assertEquals(true, conuser.delete(user1, admin));
	}
	
	/**
	 * Teste para deletar o usuario com um usuario
	 * @throws SQLException
	 * @throws UserNotFoundException
	 * @throws AdminException 
	 */
	@Test(expected=AdminException.class)
	public void testDeleteUser() throws SQLException, UserNotFoundException, AdminException {
		conuser.create(user1, admin);
		assertEquals(true, conuser.delete(user1, user1));
	}
	
	
}
