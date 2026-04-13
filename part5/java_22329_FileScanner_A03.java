import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22329_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory path

        File dir = new File(directory);

        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Here you can add code to check for injection attacks
                                // For example, check for SQL injection or other injection techniques

                                // For the sake of simplicity, we'll just print the line
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}