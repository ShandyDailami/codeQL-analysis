import java.io.*;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.Base64;

public class java_01556_FileScanner_A07 {
    private static final SecureRandom random = new SecureRandom();
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static void main(String[] args) throws IOException {
        String directory = "/path/to/directory";
        File directoryFile = new File(directory);

        if (!directoryFile.exists() || !directoryFile.isDirectory()) {
            System.out.println("Invalid directory");
            System.exit(1);
        }

        File[] hiddenFiles = directoryFile.listFiles(file -> file.isHidden() && file.canRead() && !file.getName().startsWith("."));
        if (hiddenFiles == null || hiddenFiles.length == 0) {
            System.out.println("No hidden files found");
            System.exit(1);
        }

        File selectedFile = hiddenFiles[random.nextInt(hiddenFiles.length)];
        FileReader fileReader = new FileReader(selectedFile);

        BufferedReader reader = new BufferedReader(fileReader);
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();

        String content = builder.toString();
        String encodedContent = Base64.getEncoder().encodeToString(content.getBytes());
        System.out.println("Encoded content: " + encodedContent);
    }
}