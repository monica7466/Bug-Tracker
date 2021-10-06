//package Demo.Bug.Tracker.Service.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//
//import Demo.Bug.Tracker.model.Administrator;
//import Demo.Bug.Tracker.model.Message;
//import Demo.Bug.Tracker.model.Project;
//import Demo.Bug.Tracker.model.Report;
//import Demo.Bug.Tracker.model.Staff;
//import Demo.Bug.Tracker.service.AdministratorService;
//import Demo.Bug.Tracker.service.StaffService;
//
//@SpringBootTest
//public class StaffSeviceTest {
//
//	private static Logger LOG = LoggerFactory.getLogger(StaffService.class);
//
//	@Autowired
//	private StaffService staffService;
//
//	@Autowired
//	private ApplicationContext context;
//
//	// Login Staff
//	@Test
//	public void testStaffLogin() throws Exception {
//		LOG.info("testAdminLogin");
//		Staff expected = new Staff(101, "Sonu", "Sonu");
//		Staff actual = staffService.loginStaff(1, "Sonu");
//		assertEquals(expected.getStaffId(), actual.getStaffId());
//
//		// other fields also
//	}
//
//	@Test
//	public void testStaffLoginNotFound() throws Exception {
//		LOG.info("testAdminLoginNotFound");
//		Staff unexpected = new Staff(101, "Sonu", "Sonu");
//		Staff actual = staffService.loginStaff(1, "Sonu");
//		assertNotEquals(unexpected.getStaffId(), actual.getStaffId());
//
//		// other fields also
//	}
//
//	// Add Staff Project Report
//	@Test
//	public void testAddStaffProjectReport() throws Exception {
//		LOG.info("testStaffProjectReport");
//		Report expected = context.getBean(Report.class);
//		expected.setReportId(1);
//		Report actual = staffService.addProjectReport(expected);
//		assertEquals(expected.getReportId(), actual.getReportId());
//
//		// other fields also
//	}
//
//	@Test
//	public void testAddNotStaffProjectReport() throws Exception {
//		LOG.info("testNotStaffProjectReport");
//		Report unexpected = context.getBean(Report.class);
//		unexpected.setReportId(1);
//		Report actual = staffService.addProjectReport(unexpected);
//		assertNotEquals(unexpected.getReportId(), actual.getReportId());
//
//		// other fields also
//	}
//
//	// Update Staff Project Report
//	@Test
//	public void testUpdateStaffProjectReport() throws Exception {
//		LOG.info("testUpdateStaffProjectReport");
//		Report expected = context.getBean(Report.class);
//		expected.setReportId(1);
//		Report actual = staffService.updateReport(expected);
//		assertEquals(expected.getReportId(), actual.getReportId());
//
//		// other fields also
//	}
//
//	@Test
//	public void testUpdateNotStaffProjectReport1() throws Exception {
//		LOG.info("testNotUpdateStaffProjectReport");
//		Report unexpected = context.getBean(Report.class);
//		unexpected.setReportId(1);
//		Report actual = staffService.updateReport(unexpected);
//		assertNotEquals(unexpected.getReportId(), actual.getReportId());
//
//		// other fields also
//	}
//
//	@Test
//	public void testGetAssignedProjectByStaffId() throws Exception {
//		LOG.info("testGetAssignedProjectByStaffId");
//		Report expected = context.getBean(Report.class);
//		expected.setReportId(1);
//		boolean result = staffService.getAllReport() != null;
//		assertEquals(expected, result);
//
//		// other fields also
//	}
//
//	@Test
//	public void testNotGetAssignedProjectByStaffId() throws Exception {
//		LOG.info("testNotDeleteStaffProjectReport");
//		Report unexpected = context.getBean(Report.class);
//		unexpected.setReportId(2);
//		Report actual = staffService.updateReport(unexpected);
//		assertNotEquals(unexpected.getReportId(), actual.getReportId());
//
//		// other fields also
//	}
//
//	@Test
//	public void testGetAssignedProjectOtherStaffUsingID() throws Exception {
//		LOG.info("testGetAssignedProjectOtherStaffUsingID");
//		Project expected = context.getBean(Project.class);
//		expected.setProjectID(1);
//		expected.setProjectName("Bug Track");
//		expected.setProjectPriority(1);
//		expected.setStartDateOfProject("11/09/2021");
//		expected.setEndDateOfProject("22/09/2021");
//		expected.setStaffId(2);
//		expected.setBugId(2);
//		boolean result = staffService.AssignProjectToOtherStaffUsingID(expected) != null;
//		assertEquals(expected, result);
//
//		// other fields also
//	}
//
//	@Test
//	public void testNotGetAssignedOtherStaffUsingID() throws Exception {
//		LOG.info("testNotGetAssignedOtherStaffUsingID");
//		Project unexpected = context.getBean(Project.class);
//		unexpected.setProjectID(2);
//		unexpected.setProjectName("Bug Track");
//		unexpected.setProjectPriority(1);
//		unexpected.setStartDateOfProject("11/09/2021");
//		unexpected.setEndDateOfProject("22/09/2021");
//		unexpected.setStaffId(2);
//		unexpected.setBugId(1);
//		boolean result = staffService.AssignProjectToOtherStaffUsingID(unexpected) != null;
//		assertNotEquals(unexpected, result);
//
//		// other fields also
//	}
//
//	// view all Report
//	@Test
//	public void testgetAllStaff() {
//		Staff expected = context.getBean(Staff.class);
//		expected.setStaffId(1);
//		expected.setUserName("Sonu");
//		expected.setStaffPassword("Sonu");
//		boolean result = staffService.viewAllStaff() != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotgetAllStaff() {
//		Staff unexpected = context.getBean(Staff.class);
//		unexpected.setStaffId(2);
//		unexpected.setUserName("Sonu");
//		unexpected.setStaffPassword("Sonu");
//		boolean result = staffService.viewAllStaff() != null;
//		assertNotEquals(unexpected, result);
//	}
//
//	// view all Report
//	@Test
//	public void testgetAllReport() {
//		Report expected = context.getBean(Report.class);
//		expected.setReportId(1);
//		boolean result = staffService.getAllReport() != null;
//		assertEquals(expected, result);
//	}
//
//	@Test
//	public void testNotgetAllReport() {
//		Report unexpected = context.getBean(Report.class);
//		unexpected.setReportId(2);
//		boolean result = staffService.getAllReport() != null;
//		assertNotEquals(unexpected, result);
//	}
//
//}