public class DukeException extends Exception{
    String exception;
    public DukeException(String s) {
        super();
        this.exception = s;
    }

    public String getMessage() {
        return this.exception;
    }

}
