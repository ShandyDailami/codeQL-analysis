import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_14918_FileScanner_A03 {
    private static final String DIRECTORY_PATH = "./src/main/resources"; // Replace with your directory path

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        if (directory.exists() && directory.isDirectory()) {
            File[] listOfFiles = directory.listFiles();
            Arrays.sort(listOfFiles);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the file name to search:");
            String fileName = scanner.nextLine();

            boolean fileFound = false;
            for (File file : listOfFiles) {
                if (file.getName().equalsIgnoreCase(fileName)) {
                    fileFound = true;
                    break;
                }
            }

            if (fileFound) {
                System.out.println("File found!");
            } else {
                System.out.println("File not found!");
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}