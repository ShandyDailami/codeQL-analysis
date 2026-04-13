import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24873_FileScanner_A03 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // perform security-sensitive operation here
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}