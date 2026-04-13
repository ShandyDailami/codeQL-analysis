import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_39121_FileScanner_A07 {
    private static final Set<String> BAD_NAMES = new HashSet<>(Arrays.asList("bad", "badness", "bad-words"));

    public static void main(String[] args) {
        String dirPath = args[0]; // directory to scan

        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            System.exit(1);
        }

        if (!dir.isDirectory()) {
            System.out.println("Given path is not a directory");
            System.exit(1);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path: ");
            String input = scanner.nextLine();

            if (!input.equals(dirPath)) {
                System.out.println("Input directory path does not match");
                System.exit(1);
            }

            File[] files = dir.listFiles();

            if (files == null) {
                System.out.println("Could not list files in directory");
                System.exit(1);
            }

            for (File file : files) {
                String fileName = file.getName();

                if (BAD_NAMES.contains(fileName)) {
                    throw new AuthFailureException("AuthFailure exception due to bad file name: " + fileName);
                }

                System.out.println("Processing file: " + fileName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (AuthFailureException e) {
            System.out.println(e.getMessage());
        }
    }
}