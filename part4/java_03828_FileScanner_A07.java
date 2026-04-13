import java.io.File;
import java.util.regex.Pattern;

public class java_03828_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory"; // replace with your directory path
        File dir = new File(dirPath);
        Pattern fileNamePattern = Pattern.compile("^A.*");

        File[] matchingFiles = dir.listFiles((dir1, name) -> fileNamePattern.matcher(name).matches());

        for (File file : matchingFiles) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        }
    }
}