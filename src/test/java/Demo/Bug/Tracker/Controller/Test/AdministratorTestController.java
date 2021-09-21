package Demo.Bug.Tracker.Controller.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Demo.Bug.Tracker.controller.AdminController;
import Demo.Bug.Tracker.model.Project;

public class AdministratorTestController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminController adminController;

	public void testSearchProjectById() throws Exception {
		LOG.info("testSearchProjectById");

		HttpStatus expected = HttpStatus.OK;

		ResponseEntity<Project> actual = adminController.searchProject(101);
		assertEquals(expected, actual.getStatusCode());
	}

}