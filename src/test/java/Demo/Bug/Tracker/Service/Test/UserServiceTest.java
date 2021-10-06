//package Demo.Bug.Tracker.Service.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//import org.apache.catalina.User;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//
//import Demo.Bug.Tracker.model.Bug;
//import Demo.Bug.Tracker.model.Message;
//import Demo.Bug.Tracker.model.Users;
//import Demo.Bug.Tracker.service.UsersService;
//
//@SpringBootTest
//public class UserServiceTest {
//
//	private static Logger LOG = LoggerFactory.getLogger(UsersService.class);
//
//	@Autowired
//	private UsersService usersService;
//
//	@Autowired
//	private ApplicationContext context;
//
//	// Login Staff
//	@Test
//	public void testUserLogin() throws Exception {
//		LOG.info("testUserLogin");
//		Users expected = new Users(101, "Sonu", "Sonu");
//		Users actual = usersService.loginUser(101, "Sonu");
//		assertEquals(expected, actual);
//
//		// other fields also
//	}
//
//	@Test
//	public void testStaffLoginNotFound() throws Exception {
//		LOG.info("testNotUserLogin");
//		Users unexpected = new Users(101, "Sonu", "Sonu");
//		Users actual = usersService.loginUser(102, "Sonu");
//		assertEquals(unexpected, actual);
//
//		// other fields also
//	}
//
//	// add bug
//	@Test
//	public void testgetAllBug() {
//		Bug expected = context.getBean(Bug.class);
//		expected.setBugId(1);
//		expected.setBugName("Error");
//		expected.setDescription("Error in application");
//		expected.setRaisedDate("11/09/2021");
//		boolean result = usersService.addBug(expected) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotgetAllBug1() {
//		Bug unexpected = context.getBean(Bug.class);
//		unexpected.setBugId(2);
//		unexpected.setBugName("Error");
//		unexpected.setDescription("Error in application");
//		unexpected.setRaisedDate("11/09/2021");
//		boolean result = usersService.addBug(unexpected) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// search bug
//	@Test
//	public void testSearchBug() {
//		Bug expected = context.getBean(Bug.class);
//		expected.setBugId(1);
//		expected.setBugName("Error");
//		expected.setDescription("Error in application");
//		expected.setRaisedDate("11/09/2021");
//		boolean result = usersService.searchBugByBugId(1) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotSearchBug1() {
//		Bug unexpected = context.getBean(Bug.class);
//		unexpected.setBugId(2);
//		unexpected.setBugName("Error");
//		unexpected.setDescription("Error in application");
//		unexpected.setRaisedDate("11/09/2021");
//		boolean result = usersService.searchBugByBugId(3) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// update bug
//	@Test
//	public void testUpdateBug() {
//		Bug expected = context.getBean(Bug.class);
//		expected.setBugId(1);
//		expected.setBugName("Error");
//		expected.setDescription("Error in application");
//		expected.setRaisedDate("11/09/2021");
//		boolean result = usersService.updateBugById(expected) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotUpdateBug1() {
//		Bug unexpected = context.getBean(Bug.class);
//		unexpected.setBugId(2);
//		unexpected.setBugName("Error");
//		unexpected.setDescription("Error in application");
//		unexpected.setRaisedDate("11/09/2021");
//		boolean result = usersService.updateBugById(unexpected) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// get message
//	@Test
//	public void testGetAllMessage() {
//		Message expected = context.getBean(Message.class);
//		expected.setMessageId(1);
//		expected.setMessages("Work in Progress");
//		boolean result = usersService.getMessage() != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testGetAllMessage1() {
//		Message unexpected = context.getBean(Message.class);
//		unexpected.setMessageId(1);
//		unexpected.setMessages("Work in Progress");
//		boolean result = usersService.getMessage() != null;
//		assertNotEquals(unexpected, result);
//	}
//
//}