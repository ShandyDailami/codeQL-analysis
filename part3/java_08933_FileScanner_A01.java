import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08933_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = input.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Searching for .txt files in " + dirPath);

            File[] txtFiles = dir.listFiles((File dir1, String name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    if (txtFile.canRead()) {
                        try {
                            Scanner scanner = new Scanner(txtFile);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("Error reading file: " + txtFile.getAbsolutePath());
                        }
                    } else {
                        System.out.println("File " + txtFile.getAbsolutePath() + " is not readable by the current user.");
                    }
                }
            } else {
                System.out.println("No .txt files found in " + dirPath);
            }
        } else {
            System.out.println(dirPath + " is not a valid directory.");
        }
        input.close();
    }
}