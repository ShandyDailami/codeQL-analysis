import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26405_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            String[] fileList = dir.list();

            for (String fileName : fileList) {
                File file = new File(dirPath + "/" + fileName);

                if (file.getName().toLowerCase().startsWith("a")) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }
}