import java.io.File;
import java.util.Scanner;

public class java_11024_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();

                        if (fileName.endsWith(".java")) {
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
                        }
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }
}