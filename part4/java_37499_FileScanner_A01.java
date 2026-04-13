import java.io.*;

public class java_37499_FileScanner_A01 {
    private static final String SECRET_FILE = "secret.txt";
    private static final String WRITE_MODE = "write";
    private static final String READ_MODE = "read";

    public static void main(String[] args) {
        File file = new File(SECRET_FILE);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            // Open the file in write mode
            FileWriter writer = new FileWriter(file, WRITE_MODE);

            // Write a secret message
            writer.write("This is a secret message. It should not be read by anyone!");
            writer.close();

            // Open the file in read mode
            FileReader reader = new FileReader(file, READ_MODE);

            // Read the secret message
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}