import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_11928_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Input is not a directory.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in the directory.");
            return;
        }

        Arrays.stream(files)
                .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                .forEach(file -> {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();

                            // Example of security-sensitive operation: Sending line to another process
                            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "echo " + line);
                            processBuilder.inheritIO();
                            processBuilder.start();
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}