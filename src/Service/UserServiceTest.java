package Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Entity.User;

class UserServiceTest {
UserService us = new UserService();

	@Test
	void testUserLogin() {
		User u =new User.Builder().uId(1).uPassword("123456").Build();
		assertEquals(u.getuId(),us.UserLogin(u).getuId());
	}

	@Test
	void testFindUsers() {
		assertEquals(true,us.findUsers("","General").size()>0);
	}
}
