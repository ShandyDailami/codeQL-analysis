import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_01555_FileScanner_A01 {
    private static final String SPECIFIED_EXTENSION = ".txt";
    private static final String SECURITY_RISK_PREVENTION_MESSAGE = "A01_BrokenAccessControl: Security Risk Prevention";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        List<File> txtFiles = new ArrayList<>();
        File[] txtFilesInDirectory = directory.listFiles((dir, name) -> name.endsWith(SPECIFIED_EXTENSION));

        if (txtFilesInDirectory == null) {
            System.out.println("No .txt files in directory");
            return;
        }

        for (File txtFile : txtFilesInDirectory) {
            if (txtFile.getName().contains(SECURITY_RISK_PREVENTION_MESSAGE)) {
                System.out.println("Security risk prevention message found in file: " + txtFile.getName());
            } else {
                txtFiles.add(txtFile);
            }
        }

        System.out.println("Files with security risk prevention message:");
        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getName());
        }
    }
}