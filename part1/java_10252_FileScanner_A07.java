import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class java_10252_FileScanner_A07 {

    private static final String HASHED_PASSWORDS_FILE = "hashed_passwords.txt";
    private static final String HASHED_PASSWORDS_FILE_TEMP = "hashed_passwords_temp.txt";

    public static void main(String[] args) {
        Set<String> compromisedPasswords = readCompromisedPasswords();
        File rootDirectory = new File("."); // Get current directory
        scanDirectory(rootDirectory, compromisedPasswords);
    }

    private static Set<String> readCompromisedPasswords() {
        Set<String> compromisedPasswords = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(HASHED_PASSWORDS_FILE))) {
            String password;
            while ((password = reader.readLine()) != null) {
                compromisedPasswords.add(password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compromisedPasswords;
    }

    private static void scanDirectory(File directory, Set<String> compromisedPasswords) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, compromisedPasswords);
                } else if (file.getName().endsWith(".java")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains("hashedPassword")) {
                                String compromisedPassword = extractCompromisedPassword(line);
                                if (compromisedPasswords.contains(compromisedPassword)) {
                                    System.out.println("AuthFailure detected in: " + file.getPath());
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static String extractCompromisedPassword(String line) {
        // Extract the password from the line
        // This is a very simplistic implementation, you should use a robust password extraction algorithm
        int start = line.indexOf("\"");
        int end = line.indexOf("\"", start + 1);
        if (start == -1 || end == -1) {
            throw new IllegalStateException("Malformed password string");
        }
        return line.substring(start + 1, end);
    }
}