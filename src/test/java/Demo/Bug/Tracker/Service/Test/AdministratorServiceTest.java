//package Demo.Bug.Tracker.Service.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//
//import Demo.Bug.Tracker.model.Administrator;
//import Demo.Bug.Tracker.model.Bug;
//import Demo.Bug.Tracker.model.Message;
//import Demo.Bug.Tracker.model.Project;
//import Demo.Bug.Tracker.model.Report;
//import Demo.Bug.Tracker.model.Staff;
//import Demo.Bug.Tracker.service.AdministratorService;
//
//@SpringBootTest
//public class AdministratorServiceTest {
//
//	private static Logger LOG = LoggerFactory.getLogger(AdministratorService.class);
//
//	@Autowired
//	private AdministratorService adminService;
//
//	@Autowired
//	private ApplicationContext context;
//
//	// Login Admin
//	@Test
//	public void testAdminLogin() throws Exception {
//		LOG.info("testAdminLogin");
//		Administrator expected = new Administrator(101, "Sonu", "Sonu");
//		Administrator actual = adminService.loginAdmin(101, "Sonu");
//		assertEquals(expected.getAdminId(), actual.getAdminId());
//		assertEquals(expected.getAdminName(), actual.getAdminName());
//
//		// other fields also
//	}
//
//	@Test
//	public void testAdminLoginNotFound() throws Exception {
//		LOG.info("testAdminLoginNotFound");
//		Administrator unexpected = new Administrator(102, "Monu", "Monu");
//		Administrator actual = adminService.loginAdmin(101, "Sonu");
//		assertNotEquals(unexpected.getAdminId(), actual.getAdminId());
//		assertNotEquals(unexpected.getAdminName(), actual.getAdminName());
//
//		// other fields also
//	}
//
//	// Add new Project
//	@Test
//	public void testAddProject() {
//		Project expected = context.getBean(Project.class);
//		expected.setProjectID(1);
//		expected.setProjectName("Bug Track");
//		expected.setProjectPriority(1);
//		expected.setStartDateOfProject("11/09/2021");
//		expected.setEndDateOfProject("22/09/2021");
//		boolean result = adminService.addProject(expected) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotAddProject() {
//		Project unexpected = context.getBean(Project.class);
//		unexpected.setProjectID(1);
//		unexpected.setProjectName("Bug Track");
//		unexpected.setProjectPriority(1);
//		unexpected.setStartDateOfProject("11/09/2021");
//		unexpected.setEndDateOfProject("22/09/2021");
//		boolean result = adminService.addProject(unexpected) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// Update project
//	@Test
//	public void testUpdateProject() {
//		Project expected = context.getBean(Project.class);
//		expected.setProjectID(1);
//		expected.setProjectName("Bug Track Project");
//		expected.setProjectPriority(2);
//		expected.setStartDateOfProject("11/09/2021");
//		expected.setEndDateOfProject("25/09/2021");
//		boolean result = adminService.updateProjectById(expected) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotUpdateProject() {
//		Project unexpected = context.getBean(Project.class);
//		unexpected.setProjectID(2);
//		unexpected.setProjectName("Bug Track Project");
//		unexpected.setProjectPriority(3);
//		unexpected.setStartDateOfProject("11/09/2021");
//		unexpected.setEndDateOfProject("25/09/2021");
//		boolean result = adminService.updateProjectById(unexpected) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// Delete Project
//	@Test
//	public void testDeleteProject() {
//		Project expected = context.getBean(Project.class);
//		expected.setProjectID(1);
//		expected.setProjectName("Bug Track");
//		expected.setProjectPriority(1);
//		expected.setStartDateOfProject("11/09/2021");
//		expected.setEndDateOfProject("22/09/2021");
//		expected.setStaffId(1);
//		expected.setBugId(1);
//		adminService.addProject(expected);
//		boolean result = adminService.deleteProject(expected.getProjectID()) != 0;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotDeleteProject() {
//		Project unexpected = context.getBean(Project.class);
//		unexpected.setProjectID(2);
//		unexpected.setProjectName("Bug Track");
//		unexpected.setProjectPriority(1);
//		unexpected.setStartDateOfProject("11/09/2021");
//		unexpected.setEndDateOfProject("22/09/2021");
//		unexpected.setStaffId(2);
//		unexpected.setBugId(1);
//		adminService.addProject(unexpected);
//		boolean result = adminService.deleteProject(unexpected.getProjectID()) != 0;
//		assertNotEquals(unexpected, result);
//	}
//
//	// view all Report
//	@Test
//	public void testgetAllStaff() {
//		Staff expected = context.getBean(Staff.class);
//		expected.setStaffId(1);
//		expected.setUserName("Sonu");
//		expected.setStaffPassword("Sonu");
//		boolean result = adminService.getAllStaff() != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotgetAllStaff() {
//		Staff unexpected = context.getBean(Staff.class);
//		unexpected.setStaffId(2);
//		unexpected.setUserName("Sonu");
//		unexpected.setStaffPassword("Sonu");
//		boolean result = adminService.getAllStaff() != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// Add new Staff
//	@Test
//	public void testAddStaff() {
//		Staff expected = context.getBean(Staff.class);
//		expected.setStaffId(1);
//		expected.setUserName("Sonu");
//		expected.setStaffPassword("Sonu");
//		boolean result = adminService.addNewStaff(expected) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotAddStaff() {
//		Staff unexpected = context.getBean(Staff.class);
//		unexpected.setStaffId(2);
//		unexpected.setUserName("Sonu");
//		unexpected.setStaffPassword("Sonu");
//		boolean result = adminService.addNewStaff(unexpected) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// Add update Staff
//	@Test
//	public void testUpdateStaff() {
//		Staff expected = context.getBean(Staff.class);
//		expected.setStaffId(1);
//		expected.setUserName("Sonu");
//		expected.setStaffPassword("Sonu");
//		boolean result = adminService.updateStaffById(expected) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotUpdateStaff() {
//		Staff unexpected = context.getBean(Staff.class);
//		unexpected.setStaffId(2);
//		unexpected.setUserName("Sonu");
//		unexpected.setStaffPassword("Sonu");
//		boolean result = adminService.updateStaffById(unexpected) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// Add delete Staff
//	@Test
//	public void testDeleteStaff() {
//		Staff expected = context.getBean(Staff.class);
//		expected.setStaffId(1);
//		expected.setUserName("Sonu");
//		expected.setStaffPassword("Sonu");
//		boolean result = adminService.deleteStaff(expected) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotDeleteStaff() {
//		Staff unexpected = context.getBean(Staff.class);
//		unexpected.setStaffId(2);
//		unexpected.setUserName("Sonu");
//		unexpected.setStaffPassword("Sonu");
//		boolean result = adminService.deleteStaff(unexpected) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// Search delete Staff
//	@Test
//	public void testSearchStaff() {
//		Staff expected = context.getBean(Staff.class);
//		expected.setStaffId(1);
//		expected.setUserName("Sonu");
//		expected.setStaffPassword("Sonu");
//		boolean result = adminService.searchStaffById(1) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotSearchStaff() {
//		Staff unexpected = context.getBean(Staff.class);
//		unexpected.setStaffId(2);
//		unexpected.setUserName("Sonu");
//		unexpected.setStaffPassword("Sonu");
//		boolean result = adminService.searchStaffById(1) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// view all bug
//	@Test
//	public void testgetAllBug() {
//		Bug expected = context.getBean(Bug.class);
//		expected.setBugId(1);
//		expected.setBugName("Error");
//		expected.setDescription("Error in application");
//		expected.setRaisedDate("11/09/2021");
//		boolean result = adminService.getAllBugs() != null;
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
//		boolean result = adminService.getAllBugs() != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// Search bug
//	@Test
//	public void testSearchBug() {
//		Bug expected = context.getBean(Bug.class);
//		expected.setBugId(1);
//		expected.setBugName("Error");
//		expected.setDescription("Error in application");
//		expected.setRaisedDate("11/09/2021");
//		boolean result = adminService.searchBugById(1) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotSearachBug() {
//		Bug unexpected = context.getBean(Bug.class);
//		unexpected.setBugId(2);
//		unexpected.setBugName("Error");
//		unexpected.setDescription("Error in application");
//		unexpected.setRaisedDate("11/09/2021");
//		boolean result = adminService.searchBugById(2) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// Add meassage
//	@Test
//	public void testAddMessage() {
//		Message expected = context.getBean(Message.class);
//		expected.setMessageId(1);
//		expected.setMessages("Work in Progress.");
//		boolean result = adminService.addMessage(expected) != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotAddMessage() {
//		Message unexpected = context.getBean(Message.class);
//		unexpected.setMessageId(2);
//		unexpected.setMessages("Work in Progress.");
//		boolean result = adminService.addMessage(unexpected) != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// view all Report
//	@Test
//	public void testgetAllReport() {
//		Report expected = context.getBean(Report.class);
//		expected.setReportId(1);
//		boolean result = adminService.getAllReports() != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotgetAllReport() {
//		Report unexpected = context.getBean(Report.class);
//		unexpected.setReportId(2);
//		boolean result = adminService.getAllReports() != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// view all project
//	@Test
//	public void testgetAllProject() {
//		Project expected = context.getBean(Project.class);
//		expected.setProjectID(1);
//		expected.setProjectName("Bug Track");
//		expected.setProjectPriority(1);
//		expected.setStartDateOfProject("11/09/2021");
//		expected.setEndDateOfProject("22/09/2021");
//		expected.setStaffId(1);
//		expected.setBugId(1);
//		boolean result = adminService.getAllProject() != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotgetAllProject() {
//		Project unexpected = context.getBean(Project.class);
//		unexpected.setProjectID(2);
//		unexpected.setProjectName("Bug Track");
//		unexpected.setProjectPriority(1);
//		unexpected.setStartDateOfProject("11/09/2021");
//		unexpected.setEndDateOfProject("22/09/2021");
//		unexpected.setStaffId(2);
//		unexpected.setBugId(1);
//		boolean result = adminService.getAllProject() != null;
//		assertNotEquals(unexpected, result);
//	}
//
//}