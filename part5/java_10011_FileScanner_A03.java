import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_10011_FileScanner_A03 {
    private static final Pattern VALID_FILE_NAME_CHARS = Pattern.compile("^[a-zA-Z0-9._%+-]+$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Error listing files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (validateFileName(fileName)) {
                    System.out.println("Valid file: " + file.getPath());
                } else {
                    System.out.println("Invalid file name: " + file.getPath());
                }
            }
        }

        scanner.close();
    }

    private static boolean validateFileName(String fileName) {
        return VALID_FILE_NAME_CHARS.matcher(fileName).matches();
    }
}