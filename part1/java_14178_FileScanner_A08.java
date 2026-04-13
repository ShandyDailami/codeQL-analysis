import java.io.File;
import java.util.Scanner;

public class java_14178_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("."); // This gets the current directory
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a file name:");
        String fileName = scanner.nextLine();

        fileScanner(file, fileName);
    }

    public static void fileScanner(File directory, String fileName) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && (file.getName().equals(fileName))) {
                    System.out.println("File found: " + file.getName());
                    break;
                } else {
                    if (file.isDirectory()) {
                        fileScanner(file, fileName);
                    }
                }
            }
        }
    }
}