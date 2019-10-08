package user;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import controllers.ControllerUser;
import exceptions.AdminException;
import exceptions.UserNotFoundException;
import model.bean.User;

public class TestSelect {

	private User user1;
	private User user2;
	private User admin;
	private ControllerUser conuser; 
	
	@Before
	public void setUp() throws SQLException, AdminException{
		user1 = new User("Gilberto", "Padawan", "hello", 0, false);
		user2 = new User("Bruno", "Padawan2", "hello2", 0, false);
		admin = new User("Thiago", "ObiWan", "hello@", 0, true);
		conuser = new ControllerUser();
		conuser.create(user1, admin);
	}
	
	/**
	 * Teste para selecionar o usuario com um administrador
	 * @throws SQLException
	 * @throws UserNotFoundException
	 * @throws AdminException 
	 */
	@Test
	public void testSelectAdm() throws SQLException, UserNotFoundException, AdminException {
		assertEquals(true, conuser.select(user1, admin));
	}
	
	/**
	 * Teste para selecionar o usuario com um usuario
	 * @throws SQLException
	 * @throws UserNotFoundException
	 * @throws AdminException 
	 */
	@Test(expected=AdminException.class)
	public void testSelectUser() throws SQLException, UserNotFoundException, AdminException {
		assertEquals(true, conuser.select(user1, user1));
	}
	
	/**
	 * Teste para selecionar o usuario não cadastrado com administrador
	 * @throws SQLException
	 * @throws UserNotFoundException
	 * @throws AdminException 
	 */
	@Test
	public void testSelectAdminNotfound() throws SQLException, UserNotFoundException, AdminException {
		assertEquals(true, conuser.select(user2, admin));
	}


}
