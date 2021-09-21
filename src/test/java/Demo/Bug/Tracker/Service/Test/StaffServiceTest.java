package Demo.Bug.Tracker.Service.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import Demo.Bug.Tracker.model.Staff;
import Demo.Bug.Tracker.service.StaffService;

public abstract class StaffServiceTest {

	private static Logger LOG = LoggerFactory.getLogger(StaffService.class);

	@Autowired
	private StaffService staffService;

	@Test
	public void testStaffLogin() throws Exception {
		LOG.info("testStaffLogin");
		Staff expected = new Staff(101, "Sonu", "Sonu");
		Staff actual = staffService.loginStaff(101, "Sonu");
		assertEquals(expected.getStaffId(), actual.getStaffId());
		assertEquals(expected.getStaffPassword(), actual.getStaffPassword());

		// other fields also
	}

	@Test
	public void testStaffLoginNotFound() throws Exception {
		LOG.info("teststaffLogin");
		Staff unexpected = new Staff(102, "Monu", "Monu");
		Staff actual = staffService.loginStaff(101, "Sonu");
		assertNotEquals(unexpected.getStaffId(), actual.getStaffId());
		assertNotEquals(unexpected.getStaffPassword(), actual.getStaffPassword());

		// other fields also
	}
}