import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18950_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        String fileExtension = "java";

        try {
            File directory = new File(directoryPath);
            if (directory.exists()) {
                Scanner scanner = new Scanner(directory);
                while (scanner.hasNext()) {
                    String fileName = scanner.next();
                    File file = new File(directoryPath + "/" + fileName);
                    if (file.isFile() && fileName.endsWith(fileExtension)) {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                        fileScanner.close();
                    }
                }
                scanner.close();
            } else {
                System.out.println("Directory does not exist.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}