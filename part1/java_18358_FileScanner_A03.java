import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18358_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "./src";
        File directory = new File(directoryPath);

        File[] secureFiles = directory.listFiles((dir, name) -> {
            File file = new File(dir, name);
            return file.canRead();
        });

        if (secureFiles != null) {
            for (File file : secureFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Do something with the line, e.g., print it
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}