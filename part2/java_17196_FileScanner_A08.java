import java.io.File;
import java.util.Scanner;

public class java_17196_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        // Reading a file
                        try {
                            FileReader reader = new FileReader(file);
                            int character;
                            while ((character = reader.read()) != -1) {
                                System.out.print((char) character);
                            }
                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        // Writing to a file
                        try {
                            FileWriter writer = new FileWriter(file, true);
                            writer.write("This is a line of text written to the file.");
                            writer.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}