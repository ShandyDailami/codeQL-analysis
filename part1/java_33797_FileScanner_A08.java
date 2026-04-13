import java.io.*;

public class java_33797_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        String fileName = "example.txt";
        String prefix = "A08_IntegrityFailure";
        int count = 0;

        try (FileScanner fileScanner = new FileScanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith(prefix)) {
                    count++;
                }
            }
        }

        System.out.println("The number of lines starting with \"" + prefix + "\": " + count);
    }
}