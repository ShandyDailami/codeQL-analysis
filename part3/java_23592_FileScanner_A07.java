import java.io.File;
import java.util.Scanner;

public class java_23592_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String searchString = "A07_AuthFailure";

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(searchString)) {
                                System.out.println("File " + file.getName() + " contains the string " + searchString);
                            }
                        }
                    }
                } else if (file.isDirectory()) {
                    handleDirectory(file, searchString);
                }
            }
        }
    }

    private static void handleDirectory(File directory, String searchString) {
        System.out.println("Scanning directory " + directory.getPath());

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(searchString)) {
                                System.out.println("File " + file.getName() + " contains the string " + searchString);
                            }
                        }
                    }
                } else if (file.isDirectory()) {
                    handleDirectory(file, searchString);
                }
            }
        }
    }
}