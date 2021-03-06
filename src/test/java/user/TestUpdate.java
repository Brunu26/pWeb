package user;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import controllers.ControllerUser;
import exceptions.AdminException;
import exceptions.UserNotFoundException;
import model.bean.User;

public class TestUpdate {
	
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
	 * Teste para atualizar o usuario com um administrador
	 * @throws SQLException
	 * @throws UserNotFoundException
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateAdm() throws SQLException, UserNotFoundException, AdminException {
		assertEquals(true, conuser.update("Padawan", admin, "Gilberto Souza", "bb"));
	}
	
	/**
	 * Teste para atualizar o usuario com um usuario
	 * @throws SQLException
	 * @throws UserNotFoundException
	 * @throws AdminException 
	 */
	@Test(expected=AdminException.class)
	public void testUpdateUser() throws SQLException, UserNotFoundException, AdminException {
		assertEquals(true, conuser.update("jj", user2, "Gilberto Souza", "bb"));
	}
	
	/**
	 * Teste para atualizar um usuario n�o encontrado
	 * @throws SQLException
	 * @throws UserNotFoundException
	 * @throws AdminException 
	 */
	@Test(expected=UserNotFoundException.class)
	public void testUpdateUserNot() throws SQLException, UserNotFoundException, AdminException {
		assertEquals(true, conuser.update("Gilberto", admin, "Gilberto Souza", "bb"));
	}
}
