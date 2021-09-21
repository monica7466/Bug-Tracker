package Demo.Bug.Tracker.exception;

 

public class AlreadyExistsException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
  //If the login credential then AlreadyExistsException is accessed.
    public AlreadyExistsException(String message) {
        super(message);}

 

}