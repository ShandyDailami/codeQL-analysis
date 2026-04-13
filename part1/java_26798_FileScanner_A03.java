import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26798_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "."; // Change to your desired directory
        String fileName = "A03_Injection.txt";

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}