import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class java_07239_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        File file = new File("<path-to-your-file>");
        Scanner scanner = new Scanner(file);

        int lines = 0;
        int words = 0;
        int chars = 0;
        boolean authFailureFound = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines++;
            String[] wordsInLine = line.split(" ");
            words += wordsInLine.length;
            chars += line.length();

            for (String word : wordsInLine) {
                if (word.equals("A07_AuthFailure")) {
                    authFailureFound = true;
                }
            }
        }

        scanner.close();

        System.out.println("Lines: " + lines);
        System.out.println("Words: " + words);
        System.out.println("Chars: " + chars);
        System.out.println("AuthFailureFound: " + authFailureFound);
    }
}