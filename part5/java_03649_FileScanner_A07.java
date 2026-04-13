import java.io.File;
import java.security.SecureRandom;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_03649_FileScanner_A07 {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    private String generateRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHARACTERS.charAt(secureRandom.nextInt(CHARACTERS.length())));
        }
        return stringBuilder.toString();
    }

    public void scanDirectory(String directoryPath) throws FileNotFoundException {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String filePath = file.getAbsolutePath();
                    String fileName = file.getName();
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    if (filePath.endsWith(generateRandomString(10)) && extension.matches("(jpg|jpeg|png|gif|bmp)")) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.scanDirectory("/path/to/directory");
    }
}