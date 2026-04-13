import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_08287_FileScanner_A07 {

    private static final Pattern FILE_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,16}$");

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/files.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String fileName = scanner.next();
            if (isValidFileName(fileName)) {
                System.out.println("Valid file name: " + fileName);
            } else {
                System.out.println("Invalid file name: " + fileName);
            }
        }
        scanner.close();
    }

    private static boolean isValidFileName(String fileName) {
        return FILE_NAME_PATTERN.matcher(fileName).matches();
    }
}