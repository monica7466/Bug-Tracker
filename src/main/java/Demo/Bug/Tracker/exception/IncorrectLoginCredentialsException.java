package Demo.Bug.Tracker.exception;

 

public class IncorrectLoginCredentialsException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
  //If Login credential is incorrect then IncorrectLoginCredentialsException accessed.
    public IncorrectLoginCredentialsException(String message) {
        super(message);
    }
}