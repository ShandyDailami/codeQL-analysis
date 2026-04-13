import java.io.File;
import java.util.Scanner;

public class java_06141_FileScanner_A08 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File directory = new File(currentDir);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory:");
        String path = scanner.nextLine();

        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Scanning directory: " + dir.getAbsolutePath());

            String[] files = dir.list();
            for (String file : files) {
                if (file.endsWith(".txt")) {
                    File fileObj = new File(dir.getAbsolutePath() + "/" + file);
                    if (fileObj.exists() && fileObj.canRead()) {
                        System.out.println("Found txt file: " + fileObj.getAbsolutePath());
                    } else {
                        System.out.println("Unable to read file: " + fileObj.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}