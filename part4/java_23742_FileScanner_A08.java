import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_23742_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the security sensitive operation (A08_IntegrityFailure)");
        String operation = scanner.nextLine();

        if (operation.equals("A08_IntegrityFailure")) {
            System.out.println("Security sensitive operation detected");

            File[] listOfFiles = directory.listFiles();
            Arrays.stream(listOfFiles)
                    .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                    .forEach(file -> {
                        if (!file.canRead()) {
                            System.out.println("Security violation detected: " + file.getPath());
                        } else {
                            System.out.println("File readable: " + file.getPath());
                        }
                    });
        } else {
            System.out.println("Security sensitive operation not detected");
        }
    }
}