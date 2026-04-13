import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36100_FileScanner_A07 {

    public static void main(String[] args) {
        String directory = "path_to_your_directory";
        File file = new File(directory);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                for (int i = 0; i < list.length; i++) {
                    if (list[i].isFile() && list[i].getName().endsWith(".txt")) {
                        try (Scanner scanner = new Scanner(list[i])) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Handle security-sensitive operations here
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("Provided path is not a directory");
            }
        } else {
            System.out.println("Provided path does not exist");
        }
    }
}