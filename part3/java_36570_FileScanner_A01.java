import java.io.File;
import java.util.Scanner;

public class java_36570_FileScanner_A01 {
    private static final String EXTENSION = ".txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(EXTENSION));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("Reading file: " + txtFile.getAbsolutePath());

                try (Scanner fileScanner = new Scanner(txtFile)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                }
            }
        } else {
            System.out.println("No .txt files found in the directory");
        }
    }
}