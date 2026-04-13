import java.io.File;
import java.util.Scanner;

public class java_11615_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Specify your directory path here
        String wordToSearch = "security-sensitive"; // Specify the word you are searching for here

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(wordToSearch)) {
                                System.out.println("Security-Sensitive operation found in: " + file.getAbsolutePath());
                            }
                       
                        }
                        scanner.close();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}