import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_35676_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources");
        String[] list = file.list();

        if (list != null) {
            Arrays.sort(list);

            for (String name : list) {
                File f = new File(file, name);

                if (f.isFile() && name.endsWith(".java")) {
                    try (Scanner scanner = new Scanner(f)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();

                            if (line.contains("A07_AuthFailure")) {
                                System.out.println("File: " + f.getAbsolutePath() + ", Line: " + line);
                            }
                        }
                    }
                }
            }
        }
    }
}