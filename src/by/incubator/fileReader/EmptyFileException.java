package by.incubator.fileReader;

public class EmptyFileException extends Exception{
    private String filePath;

    public EmptyFileException (String message, String filePath) {
        super(message);
        this.filePath = filePath;
    }

    public EmptyFileException (String message, Throwable cause, String filePath) {
        super(message, cause);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
