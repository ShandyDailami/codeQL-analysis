import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18783_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String userPath = System.getProperty("user.dir"); // get the current user's directory

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] hiddenFiles = directory.listFiles(file -> file.isHidden() && file.canRead() && file.getAbsolutePath().startsWith(userPath));

            if (hiddenFiles != null) {
                for (File file : hiddenFiles) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No hidden files in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}