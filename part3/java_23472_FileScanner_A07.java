import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_23472_FileScanner_A07 {
    private static final String DIR = "/path/to/directory";
    private static final String EXT = ".txt";

    public static void main(String[] args) {
        Set<String> fileNames = new HashSet<>();
        Set<String> filePaths = new HashSet<>();

        // Scan for files in directory
        File directory = new File(DIR);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(EXT)) {
                    fileNames.add(file.getName());
                    filePaths.add(file.getPath());
                }
            }
        }

        // Scan for suspicious file names
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter file name to check (or 'q' to quit): ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
            String fileName = input + EXT;
            if (fileNames.contains(fileName)) {
                System.out.println("Suspicious file: " + fileName);
                System.out.println("File path: " + filePaths.get(fileNames.indexOf(fileName)));
            } else {
                System.out.println("File not found: " + fileName);
            }
        }
        scanner.close();
    }
}