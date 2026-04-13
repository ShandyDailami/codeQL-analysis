import java.io.File;
import java.util.Scanner;

public class java_41521_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File: " + file.getName());
                        FileReader fileReader = null;
                        try {
                            fileReader = new FileReader(file);
                            int data;
                            while ((data = fileReader.read()) != -1) {
                                if (data >= 97 && data <= 122) {
                                    System.out.print((char) data);
                                }
                            }
                            fileReader.close();
                        } catch (Exception e) {
                            System.out.println("Error occurred while reading file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}