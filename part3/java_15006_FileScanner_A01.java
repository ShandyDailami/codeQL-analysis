import java.io.File;
import java.util.Scanner;

public class java_15006_FileScanner_A01 {
    private static final String DIRECTORY = "C:\\Users\\username\\documents\\";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(DIRECTORY + path);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] hiddenFiles = directory.listFiles(file -> file.isFile() && file.getName().startsWith(".") && file.getName().endsWith(".log"));

        if (hiddenFiles == null) {
            System.out.println("No hidden files found.");
            return;
        }

        System.out.println("Hidden files:");
        for (File file : hiddenFiles) {
            System.out.println(file.getName());
        }

        scanner.close();
    }
}