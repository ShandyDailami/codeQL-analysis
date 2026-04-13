import java.io.File;
import java.util.Scanner;

public class java_23701_FileScanner_A07 {
    private static final String DIRECTORY = "C:\\Users\\Public"; // Adjust this to your desired directory

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        for (File file : files) {
            if (file.getName().equals(fileName)) {
                System.out.println("File found: " + file.getAbsolutePath());
                return;
            }
        }

        System.out.println("File not found");
    }
}