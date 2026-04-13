import java.io.File;
import java.util.Scanner;

public class java_37990_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try {
                        FileReader reader = new FileReader(file);
                        int character;
                        while ((character = reader.read()) != -1) {
                            System.out.print((char) character);
                        }
                        reader.close();
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getPath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }

        scanner.close();
    }
}