import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_20853_FileScanner_A07 {

    private List<File> files = new ArrayList<>();
    private List<String> fileContents = new ArrayList<>();

    public java_20853_FileScanner_A07(String directoryPath) {
        File directory = new File(directoryPath);

        getFileContents(directory);
    }

    private void getFileContents(File directory) {
        File[] listOfFiles = directory.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && (listOfFiles[i].getName().endsWith(".java"))) {
                files.add(listOfFiles[i]);
            } else if (listOfFiles[i].isDirectory()) {
                getFileContents(listOfFiles[i]);
            }
        }

        for (File file : files) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String content = scanner.nextLine();
                    if (content.contains("AuthFailure")) {
                        fileContents.add(content);
                    }
                }
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        printFileContents();
    }

    private void printFileContents() {
        for (String content : fileContents) {
            System.out.println(content);
        }
    }

    public static void main(String[] args) {
        new AuthFailureScanner("src/main/java");
    }
}