import java.io.File;
import java.util.Scanner;

public class java_23735_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try {
                            FileReader reader = new FileReader(file);
                            int data;
                            while ((data = reader.read()) != -1) {
                                char ch = (char) data;
                                if (ch == 'A') {
                                    System.out.println("The file " + file.getName() + " contains 'A' which is not allowed in the context of A07_AuthFailure.");
                                }
                            }
                            reader.close();
                        } catch (Exception e) {
                            System.out.println("Error reading file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}