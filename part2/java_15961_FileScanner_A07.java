import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_15961_FileScanner_A07 {
    private static final String ROOT_DIR = "C:\\";

    public static void main(String[] args) {
        File file = new File(ROOT_DIR);
        File[] listOfFiles = file.listFiles();
        if (listOfFiles != null) {
            Arrays.sort(listOfFiles, (o1, o2) -> {
                if (o1.isDirectory() && o2.isFile()) return -1;
                if (o2.isDirectory() && o1.isFile()) return 1;
                return o1.compareTo(o2);
            });

            for (File listFile : listOfFiles) {
                if (listFile.isFile()) {
                    String name = listFile.getName();
                    if (name.endsWith(".txt")) {
                        try (Scanner scanner = new Scanner(listFile)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                if (line.matches(".*A07_AuthFailure.*")) {
                                    System.out.println("Security Violation: " + line);
                                }
                            }
                        }
                    }
                } else if (listFile.isDirectory()) {
                    System.out.println("Directory: " + listFile.getPath());
                }
            }
        }
    }
}