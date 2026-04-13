import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13391_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File startingDirectory = new File("."); // The current directory
        String secretWord = "secret";

        FileScanner(startingDirectory, secretWord);
    }

    public static void FileScanner(File directory, String secretWord) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (containsSecretWord(file, secretWord)) {
                        System.out.println("File: " + file.getAbsolutePath() + " contains secret word");
                    }
                } else if (file.isDirectory()) {
                    FileScanner(file, secretWord);
                }
            }
        }
    }

    private static boolean containsSecretWord(File file, String secretWord) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(secretWord)) {
                return true;
            }
        }
        return false;
    }
}