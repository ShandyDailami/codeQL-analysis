import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_18852_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (txtFiles == null) {
            return;
        }

        Arrays.stream(txtFiles)
                .filter(file -> file.isFile())
                .forEach(file -> {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                       
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                });
    }
}