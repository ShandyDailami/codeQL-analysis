import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10198_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory";  // replace with your directory path
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] hiddenFiles = dir.listFiles(file -> file.isHidden());

            if (hiddenFiles != null) {
                for (File hiddenFile : hiddenFiles) {
                    if (hiddenFile.isFile() && hiddenFile.getName().endsWith(".txt")) {
                        Scanner scanner = null;
                        try {
                            scanner = new Scanner(hiddenFile);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Here you can add your authentication logic to prevent AuthFailure
                                // For now, just print the line
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } finally {
                            if (scanner != null) {
                                scanner.close();
                            }
                        }
                    }
                }
            }
        }
    }
}