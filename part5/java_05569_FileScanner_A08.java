import java.io.*;
import java.util.*;

public class java_05569_FileScanner_A08 {
    private static final String RESTRICTED_FOLDER = "restricted_folder";
    private static final String FILE_NAME = "test.txt";
    private static final String BASE_PATH = System.getProperty("user.dir") + "/" + RESTRICTED_FOLDER + "/";
    private static final String PATH = BASE_PATH + FILE_NAME;
    private static final String RESTRICTED_FILE_CONTENT = "Restricted file content";

    public static void main(String[] args) {
        createRestrictedFolder();
        writeToRestrictedFile();
        scanRestrictedFile();
    }

    private static void createRestrictedFolder() {
        File restrictedFolder = new File(BASE_PATH);
        if (!restrictedFolder.exists()) {
            restrictedFolder.mkdirs();
        }
    }

    private static void writeToRestrictedFile() {
        File restrictedFile = new File(PATH);
        try (FileWriter writer = new FileWriter(restrictedFile)) {
            writer.write(RESTRICTED_FILE_CONTENT);
            System.out.println("Restricted file content has been written to " + restrictedFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanRestrictedFile() {
        try (FileScanner scanner = new FileScanner(new File(PATH))) {
            while (scanner.hasNext()) {
                System.out.println("Found restricted file content: " + scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Restricted file not found at " + PATH);
        }
    }
}