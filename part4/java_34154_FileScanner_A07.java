import java.io.*;

public class java_34154_FileScanner_A07 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_PATTERN = "file_pattern";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] matchingFiles = directory.listFiles((dir, name) -> name.matches(FILE_PATTERN));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                if (!file.canRead()) {
                    System.out.println("File " + file.getAbsolutePath() + " is not readable. Authentication failure.");
                } else {
                    System.out.println("File " + file.getAbsolutePath() + " is readable. Authentication successful.");
                }
            }
        } else {
            System.out.println("Directory " + directory.getAbsolutePath() + " does not exist.");
        }
    }
}