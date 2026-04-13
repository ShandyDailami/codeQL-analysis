import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07855_FileScanner_A07 {

    public static class AuthFailureException extends Exception {
        public java_07855_FileScanner_A07(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        String fileName = "authFailure.txt";

        try {
            File file = new File(dirPath + "/" + fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new AuthFailureException("File not found");
        } catch (AuthFailureException e) {
            e.printStackTrace();
        }
    }
}