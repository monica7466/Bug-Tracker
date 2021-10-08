package Demo.Bug.Tracker.exception;

public class NoSuchProjectStaffBugReportExceptionToUpdate extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

 
    // If given record is not present in the list of record then NoSuchRecordException is accessed.
    public NoSuchProjectStaffBugReportExceptionToUpdate(String message) {
        super(message);
    }
}
