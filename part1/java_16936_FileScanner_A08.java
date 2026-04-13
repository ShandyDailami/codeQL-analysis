import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_16936_FileScanner_A08 {

    private static final String PATH = "C:\\path_to_your_directory";

    public static void main(String[] args) {
        File file = new File(PATH);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file to scan:");
        String fileName = scanner.nextLine();
        fileName = fileName.concat(".txt");
        File targetFile = new File(file.getAbsolutePath(), fileName);
        if (targetFile.exists()) {
            System.out.println("File exists: " + targetFile.getAbsolutePath());
            scanFile(targetFile);
        } else {
            System.out.println("File does not exist: " + targetFile.getAbsolutePath());
        }
    }

    private static void scanFile(File file) {
        if (file.isFile()) {
            System.out.println("File: " + file.getName());
            if (file.canRead()) {
                System.out.println("File content: " + readFile(file));
            } else {
                System.out.println("Access denied for reading the file: " + file.getAbsolutePath());
            }
        } else if (file.isDirectory()) {
            System.out.println("Directory: " + file.getAbsolutePath());
            File[] files = file.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(UniqueVanillaFileScanner::scanFile);
            }
        } else {
            System.out.println("Unable to process the request for " + file.getAbsolutePath());
        }
    }

    private static String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error while reading the file: " + file.getAbsolutePath());
        }
        return content.toString();
    }
}