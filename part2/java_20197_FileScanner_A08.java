import java.io.*;
import java.util.Scanner;

public class java_20197_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName();
                if (name.endsWith(".txt")) {
                    FileReader reader = new FileReader(file);
                    int content;
                    while ((content = reader.read()) != -1) {
                        System.out.print((char) content);
                    }
                    reader.close();
                }
            }
        }

        scanner.close();
    }
}