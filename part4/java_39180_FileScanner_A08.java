import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39180_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory
        String keywords = "integrity failure"; // replace with your keywords

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.length() > 1024 * 1024) { // size check
                        try (Scanner scanner = new Scanner(file)) {
                            boolean containsKeywords = false;

                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();

                                if (line.toLowerCase().contains(keywords)) {
                                    containsKeywords = true;
                                    break;
                                }
                            }

                            if (!containsKeywords) {
                                file.delete();
                                System.out.println("File deleted: " + file.getAbsolutePath());
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or it's not a directory.");
        }
    }
}