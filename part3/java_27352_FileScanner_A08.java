import java.io.File;
import java.util.Scanner;

public class java_27352_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String name = file.getName();

                        if (name.endsWith(".txt")) {
                            try {
                                FileReader reader = new FileReader(file);

                                int data;
                                while ((data = reader.read()) != -1) {
                                    char ch = (char) data;
                                    System.out.print(ch);
                                }

                                reader.close();
                            } catch (Exception e) {
                                System.out.println("Error reading file: " + file.getName());
                            }
                        }
                    }
                }
            } else {
                System.out.println("No files in directory.");
            }
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }
}