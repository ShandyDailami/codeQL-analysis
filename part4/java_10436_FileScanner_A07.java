import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10436_FileScanner_A07 {
    private static final String PASSWORD_FILE_NAME = "password.txt";
    private static final String WORD_TO_COUNT = "A07_AuthFailure";

    public static void main(String[] args) {
        String password = readPasswordFile();
        countWordOccurrences(password);
    }

    private static String readPasswordFile() {
        try (Scanner scanner = new Scanner(new File(PASSWORD_FILE_NAME))) {
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Password file not found!");
        }
        return "";
    }

    private static void countWordOccurrences(String password) {
        File[] files = new File(".").listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    Scanner scanner = new Scanner(file);
                    int count = 0;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        count += line.split(WORD_TO_COUNT).length - 1;
                    }
                    System.out.println("In file " + file.getName() + ", the word 'A07_AuthFailure' occurred " + count + " times");
                }
            }
        }
    }
}