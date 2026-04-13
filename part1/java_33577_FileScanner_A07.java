import java.io.File;
import java.util.Arrays;

public class java_33577_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("your_directory_here");
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            });
        }
    }
}