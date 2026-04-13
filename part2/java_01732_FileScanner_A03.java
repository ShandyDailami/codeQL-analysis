import java.io.File;
import java.util.Scanner;

public class java_01732_FileScanner_A03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        System.out.println("Processing file: " + file.getName());
                        String contents = readFileContents(file);
                        if (contents.contains("injection")) {
                            System.out.println("Suspicious activity detected in file: " + file.getName());
                            System.out.println("Contents: " + contents);
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }

    private static String readFileContents(File file) {
        StringBuilder contents = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                contents.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents.toString();
    }
}