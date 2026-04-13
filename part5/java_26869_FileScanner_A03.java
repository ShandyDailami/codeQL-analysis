import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class java_26869_FileScanner_A03 {
    public static void main(String[] args) {
        System.out.println("Enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.canRead()) {
                        try (FileInputStream fis = new FileInputStream(file)) {
                            byte[] byteArray = new byte[fis.available()];
                            fis.read(byteArray);
                            String fileContent = new String(byteArray, "UTF-8");
                            System.out.println("Content of file: " + file.getName());
                            System.out.println(fileContent);
                        } catch (IOException e) {
                            System.out.println("Error reading file: " + file.getName());
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path!");
        }
    }
}