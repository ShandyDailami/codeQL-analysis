import java.io.File;
import java.util.regex.Pattern;

public class java_32817_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String typeFilter = ".*\\.java$"; // replace with your type filter

        File dir = new File(directory);
        File[] files = dir.listFiles((File pathname) -> {
            if (pathname.isFile() && Pattern.matches(typeFilter, pathname.getName())) {
                return true;
            } else {
                return false;
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        }
    }
}