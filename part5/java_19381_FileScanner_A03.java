import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19381_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // specify your directory here
        String fileType = ".txt"; // specify your file type here

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileType));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    try {
                        Scanner scanner = new Scanner(txtFile);
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No txt files found in the directory.");
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}