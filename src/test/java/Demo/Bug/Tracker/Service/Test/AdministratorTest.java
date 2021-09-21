package Demo.Bug.Tracker.Service.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import Demo.Bug.Tracker.model.Administrator;
import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.service.AdministratorService;

@SpringBootTest
public class AdministratorTest {

	private static Logger LOG = LoggerFactory.getLogger(AdministratorService.class);

	@Autowired
	private AdministratorService adminService;

	@Autowired
	private ApplicationContext context;

	@Test
	public void testAdminLogin() throws Exception {
		LOG.info("testAdminLogin");
		Administrator expected = new Administrator(101, "Sonu", "Sonu");
		Administrator actual = adminService.loginAdmin(101, "Sonu");
		assertEquals(expected.getAdminId(), actual.getAdminId());
		assertEquals(expected.getAdminName(), actual.getAdminName());

		// other fields also
	}

	@Test
	public void testAdminLoginNotFound() throws Exception {
		LOG.info("testAdminLoginNotFound");
		Administrator unexpected = new Administrator(102, "Monu", "Monu");
		Administrator actual = adminService.loginAdmin(101, "Sonu");
		assertNotEquals(unexpected.getAdminId(), actual.getAdminId());
		assertNotEquals(unexpected.getAdminName(), actual.getAdminName());

		// other fields also
	}

//    @Test
//    public void testAddProject() throws Exception {
//        LOG.info("testAddUserSuccess");
//        boolean expected = true;
//        Administrator project = new Administrator();
//        boolean actual = adminService.addProject(project pid);
//        assertEquals(expected, actual);
//    }

	@Test
	public void testAddProject() {
		Project expected = context.getBean(Project.class);
		expected.setProjectID(1);
		expected.setProjectName("Bug Track");
		expected.setProjectPriority(1);
		expected.setStartDateOfProject("11/09/2021");
		expected.setEndDateOfProject("22/09/2021");
		boolean result = adminService.addProject(expected) != null;
		assertEquals(expected, result);
	}

	@Test
	public void testUpdateProject() {
		Project expected = context.getBean(Project.class);
		expected.setProjectID(1);
		expected.setProjectName("Bug Track Project");
		expected.setProjectPriority(2);
		expected.setStartDateOfProject("11/09/2021");
		expected.setEndDateOfProject("25/09/2021");
		boolean result = adminService.updateProjectById(expected) != null;
		assertEquals(expected, result);
	}

	@Test
	public void testDeleteProject() {
		Project expected = context.getBean(Project.class);
		expected.setProjectID(1);
		expected.setProjectName("Bug Track");
		expected.setProjectPriority(1);
		expected.setStartDateOfProject("11/09/2021");
		expected.setEndDateOfProject("22/09/2021");
		expected.setStaffId(1);
		expected.setBugId(1);
		adminService.addProject(expected);
		boolean result = adminService.deleteProject(expected.getProjectID()) != 0;
		assertTrue(result);
	}

}