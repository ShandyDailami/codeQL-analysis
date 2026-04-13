import java.io.*;

public class java_41805_FileScanner_A08 {

    private static final String INPUT_DIRECTORY = "./";

    public static void main(String[] args) {
        File directory = new File(INPUT_DIRECTORY);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        // Read file content
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Here, you can add your own security-sensitive operations related to A08_IntegrityFailure
                            System.out.println(line);
                        }
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}