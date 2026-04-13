import java.io.File;
import java.util.Arrays;

public class java_25730_FileScanner_A07 {

    public static void main(String[] args) {
        String dirPath = "/path/to/your/directory"; // replace with your directory
        File dir = new File(dirPath);

        File[] hiddenFiles = dir.listFiles((File pathname) -> pathname.isHidden());

        if (hiddenFiles != null) {
            Arrays.stream(hiddenFiles)
                    .filter(file -> file.isFile() && !file.getName().endsWith(".java"))
                    .forEach(file -> System.out.println("Hidden file: " + file.getPath()));
        } else {
            System.out.println("Directory is empty or does not exist");
        }
    }
}