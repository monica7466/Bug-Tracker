package Demo.Bug.Tracker.exception;

 

public class ProjectNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
    // If given project is not present in the list of project then ProjectNotFoundException is accessed.
    public ProjectNotFoundException(String message) {
        super(message);
    }
}