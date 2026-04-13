import java.io.File;
import java.util.regex.Pattern;

public class java_22971_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File("."); // Point to the directory you want to scan
        Pattern pattern = Pattern.compile("test"); // Pattern you want to match

        File[] matchingFiles = directory.listFiles((dir, name) -> pattern.matcher(name).matches());

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found!");
        }
    }
}