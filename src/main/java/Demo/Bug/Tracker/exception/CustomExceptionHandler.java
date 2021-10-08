package Demo.Bug.Tracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(BugNotFoundException.class)
	public ResponseEntity<Object> handleBugNotFoundException() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>("Bug is not present in database", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IncorrectLoginCredentialsException.class)
	public ResponseEntity<Object> handleIncorrectLoginCredentialsException() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>("Invalid Login Credential", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidFieldException.class)
	public ResponseEntity<Object> handleInvalidFieldException() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>("Fields are empty", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchRecordException.class)
	public ResponseEntity<Object> handleNoSuchRecordException() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>("List is empty", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchProjectStaffBugReportExceptionToUpdate.class)
	public ResponseEntity<Object> handleNoSuchProjectStaffBugReportExceptionToUpdate() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>("Given id does not exist to Update", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchProjectStaffBugReportExceptionToDelete.class)
	public ResponseEntity<Object> handleNoSuchProjectStaffBugReportExceptionToDelete() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>("Given id does not exist to Delete", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StaffNotFoundException.class)
	public ResponseEntity<Object> handleStaffNotFoundException() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>("Staff is not present ", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ReportNotFoundException.class)
	public ResponseEntity<Object> handleReportNotFoundException() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>("Report is not present ", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ProjectNotFoundException.class)
	public ResponseEntity<Object> handleProjectNotFoundException() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>("Project is not present ", HttpStatus.NOT_FOUND);
	}

}