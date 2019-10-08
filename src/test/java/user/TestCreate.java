package user;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import controllers.ControllerUser;
import exceptions.AdminException;
import exceptions.UserNotFoundException;
import model.bean.User;

public class TestCreate {
	
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
	 * Teste para adicionar um usuario com outro usuario administrador
	 * @throws SQLException
	 * @throws UserAddException
	 * @throws AdminException
	 */
	@Test
	public void testCreateAdm() throws SQLException, AdminException {
		assertEquals(true, conuser.create(user1, admin));
	}
	/**
	 * Teste para deletar um usuario com outro usuario
	 * @throws SQLException
	 * @throws AdminException
	 */
	@Test(expected=AdminException.class)
	public void testCreateUser() throws SQLException, AdminException {
		assertEquals(true, conuser.create(user1, user2));
	}

	
}
