package Demo.Bug.Tracker.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import Demo.Bug.Tracker.exception.InvalidFieldException;
import Demo.Bug.Tracker.exception.NoSuchRecordException;
import Demo.Bug.Tracker.exception.ProjectNotFoundException;
import Demo.Bug.Tracker.exception.BugNotFoundException;
import Demo.Bug.Tracker.exception.IncorrectLoginCredentialsException;

//import  Demo.Bug.Tracker.service.AdministratorService;

import Demo.Bug.Tracker.model.Administrator;
import Demo.Bug.Tracker.model.Bug;
import Demo.Bug.Tracker.model.Message;
import Demo.Bug.Tracker.model.Project;
import Demo.Bug.Tracker.model.Staff;
import Demo.Bug.Tracker.service.AdministratorService;

@CrossOrigin
@RestController
public class AdminController {
	@Autowired
	AdministratorService adminService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AdministratorService.class);
	
//  @PostMapping(path = "/-/addAdmin")
//  public ResponseEntity<String> saveAdmin(@RequestBody Administrator admin) throws InvalidFieldException {
//      ResponseEntity<String> response = null;
//      if (adminService.addAdmin(admin)) {
//          response = new ResponseEntity<String>(admin.toString(), HttpStatus.CREATED);
//      }
//      return response;
//  }
 
  @PostMapping(path = "/AdminLogin")
  public ResponseEntity<Administrator> adminLogin(@RequestBody Administrator admin)
          throws IncorrectLoginCredentialsException{
      Administrator result = adminService.loginAdmin(admin.getAdminId(), admin.getAdminPassword());
      ResponseEntity<Administrator> response = new ResponseEntity<>(result, HttpStatus.OK);
      return response;
  }
	@GetMapping("/")
    public String index() {
    System.out.println("index");
    return "index";
    }
   
    //http://localhost:8080/Project/getAllProject
    @GetMapping("/Project/getAllProject")
    public List<Project> getAllProject() throws NoSuchRecordException {
        LOG.info("getAllProject");
        return adminService.getAllProject();
    }
    @GetMapping("/searchProject/{adminId}")
    public ResponseEntity<Project> searchProject(@PathVariable int adminId) throws ProjectNotFoundException {
        LOG.info("getEmp");
        Project project = adminService.searchProjectById(adminId);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
    
  //http://localhost:8080/Project/addProject
    @PostMapping("/Project/addProject")
    public Project addProject(@RequestBody Project project) throws NoSuchRecordException{
            LOG.info("addProject");
            return adminService.addProject(project);
        }
    
  //http://localhost:8080/Project/updateProject
    @PutMapping("/Project/updateProject/{projectID}")  //InvalidId
      public Project updateProjectById(@RequestBody Project projectID) throws NoSuchRecordException{
          return adminService.updateProjectById(projectID);
      }
   
    //http://localhost:8080/Project/deleteProject{projectID}
    @DeleteMapping("/Project/deleteProject/{projectID}") //InvalidId
    public int deleteProject(@PathVariable int projectID) throws NoSuchRecordException{
        LOG.info("deleteProject");
        return adminService.deleteProject(projectID);
    }
		
  //STAFF tasks
    //view all staff member details
    @GetMapping("/Staff/getAllStaff")
    public List<Staff> getAllStaff() throws NoSuchRecordException{
        System.out.println("getStaff");
        return adminService.getAllStaff();
    }
   
    //add new staff member details
    @PostMapping("/staff/addNewStaff")
    public Staff addNewStaff(@RequestBody Staff staff) throws NoSuchRecordException{
        return adminService.addNewStaff(staff);
    }
    
  //update new staff member details
    @PutMapping("/staff/updateStaff/{staffId}") ////InvalidStaffId
    public Staff updateStaffById(@RequestBody Staff staffId) throws NoSuchRecordException{
        return adminService.updateStaffById(staffId);
    }
   
    //delete new staff member details
    @DeleteMapping("/staff/deleteStaffById/{staffId}") ///InvalidStaffId
    public Staff deleteStaffById(@PathVariable Staff staffId) throws NoSuchRecordException{
        return adminService.deleteStaff(staffId);
    }
	
  //BUGS tasks
    @GetMapping("/bug/getAllbugs")
    public List<Bug> getAllBugs() throws NoSuchRecordException{
        System.out.println("get all bugs");
        return adminService.getAllBugs();
    }
//	
//	@GetMapping("/bug/getReportById")
//	public List<Bug> getReportById(@RequestBody Bug bugId) {
//		System.out.println("Get solutions by Id");
//		return adminService.getReportById(bugId);
//	}
//	
    @GetMapping("/Bug/searchBug{bugId}")
    public ResponseEntity<Bug> searchBug(@PathVariable int bugId) throws BugNotFoundException{
        LOG.info("Search bugs by id");
        Bug bug = adminService.searchBugById(bugId);
        return new ResponseEntity<Bug>(bug, HttpStatus.OK);
    }




@ResponseStatus(code = HttpStatus.NOT_FOUND,reason="Fields are empty")
@ExceptionHandler(value = InvalidFieldException.class)
public ResponseEntity<String> handleInvalidFiedsException() {
    return new ResponseEntity<String>("Fields are empty", HttpStatus.OK);
}
	
	//message operations
	@PostMapping("/message/addMessage")
	public Message addMessage(@RequestBody Message message) {
		return adminService.addMessage(message);
	}
}
