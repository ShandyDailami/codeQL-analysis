import java.io.File;
import java.util.Scanner;

public class java_26127_FileScanner_A07 {

    private static final String SPECIFIED_FORMAT = ".txt";
    private static final String AUTH_FAILURE_KEY = "A07_AuthFailure";
    private static final String INITIAL_DIRECTORY = "/path/to/directory";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Specified path is not a directory!");
            return;
        }

        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(SPECIFIED_FORMAT));

        if (listOfFiles == null) {
            System.out.println("Unable to read directory!");
            return;
        }

        System.out.println("Files with " + AUTH_FAILURE_KEY + " in the name:");

        for (File file : listOfFiles) {
            if (file.getName().contains(AUTH_FAILURE_KEY)) {
                System.out.println(file.getName());
            }
        }
    }
}