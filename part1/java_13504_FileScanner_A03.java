import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13504_FileScanner_A03 {
    private static final String DIRECTORY_PATH = "src/main/resources"; // replace with your directory path

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();

            for (String file : files) {
                File fileObj = new File(directory.getPath() + "/" + file);

                if (fileObj.exists() && fileObj.isFile()) {
                    try (Scanner scanner = new Scanner(fileObj)) {
                        while (scanner.hasNextLine()) {
                            String content = scanner.nextLine();

                            // Here, you might want to sanitize the content or handle injection attacks.
                            // For simplicity, we're just printing it.
                            System.out.println(content);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("The provided directory does not exist or is not a directory.");
        }
    }
}