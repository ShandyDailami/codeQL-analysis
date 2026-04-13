import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_41869_FileScanner_A08 {
    private static final Set<String> IGNORE_FILES = new HashSet<>(Arrays.asList(".", "..", "readme.md", ".gitignore", ".idea", "bin", "obj", "target"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory to scan:");
        String dir = scanner.nextLine();

        try (FileScanner scanner = new FileScanner(dir)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (file.isDirectory() || IGNORE_FILES.contains(file.getName())) {
                    continue;
                }

                try (FileInputStream input = new FileInputStream(file)) {
                    if (checkIntegrity(input)) {
                        System.out.println("File: " + file.getAbsolutePath() + " has integrity!");
                    } else {
                        System.out.println("File: " + file.getAbsolutePath() + " has failed integrity check!");
                    }
                } catch (IOException e) {
                    System.out.println("Failed to read file: " + file.getAbsolutePath());
                }
            }
        }
    }

    private static boolean checkIntegrity(FileInputStream input) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) != -1) {
            md.update(buffer, 0, length);
        }

        byte[] digest = md.digest();
        return new BigInteger(1, digest).compareTo(BigInteger.ONE) == 0;
    }
}

class FileScanner implements AutoCloseable {
    private File[] files;
    private int index;

    public java_41869_FileScanner_A08(String dir) {
        File dirFile = new File(dir);
        if (!dirFile.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + dir);
        }

        files = dirFile.listFiles();
        if (files == null) {
            files = new File[0];
        }
    }

    public File nextFile() {
        return files[index++];
    }

    public boolean hasNext() {
        return index < files.length;
    }

    @Override
    public void close() {
        // Nothing to close in this implementation
    }
}