import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19293_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String authFailureFile = "AuthFailure.java";

        try {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.getName().equals(authFailureFile)) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}