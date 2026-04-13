import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36988_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] files = directory.list();

            for (String fileName : files) {
                File file = new File(directoryPath + "/" + fileName);

                if (file.isFile() && file.canRead()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("The specified file does not exist.");
        }
    }
}