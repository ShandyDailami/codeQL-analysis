import java.io.File;
import java.util.Scanner;

public class java_38746_FileScanner_A07 {
    private static final String DIRECTORY = "src/main/resources/";
    private static final String FILE_EXTENSION = ".txt";
    private static final String AUTH_FAILURE_KEYWORD = "A07_AuthFailure";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = scanner.nextLine();
        System.out.print("Enter auth failure keyword: ");
        String authFailureKeyword = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
        if (files == null) {
            System.out.println("No files found in the directory.");
            return;
        }

        for (File file : files) {
            if (file.getName().contains(authFailureKeyword)) {
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                } catch (Exception e) {
                    System.out.println("Error reading file: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}