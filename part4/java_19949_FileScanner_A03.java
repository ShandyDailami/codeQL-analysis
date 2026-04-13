import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19949_FileScanner_A03 {
    private static final String SECRET_DIRECTORY = "secret_directory";
    private static final String SECRET_FILE = "secret_file";
    private static final String WRITE_MODE = "write";

    public static void main(String[] args) {
        File directory = new File(SECRET_DIRECTORY);
        File file = new File(directory, SECRET_FILE);

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    System.out.println("Read from file: " + line);

                    if (WRITE_MODE.equals(line)) {
                        System.out.println("Writing to file...");
                        file.setWritable(true);
                        try (Scanner writeScanner = new Scanner(System.in)) {
                            System.out.println("Enter your secret message:");
                            String writeLine = writeScanner.nextLine();
                            file.setWritable(false);
                            try (Scanner readWriteScanner = new Scanner(file)) {
                                while (readWriteScanner.hasNext()) {
                                    String readLine = readWriteScanner.nextLine();
                                    System.out.println("Read from file after write: " + readLine);
                                }
                            }
                            file.setWritable(true);
                            file.createNewFile();
                            try (Scanner readWriteScanner = new Scanner(file)) {
                                while (readWriteScanner.hasNext()) {
                                    String readLine = readWriteScanner.nextLine();
                                    System.out.println("Read from file after creation: " + readLine);
                               
                                }
                            }
                            file.setWritable(false);
                            file.delete();
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter your secret message:");
                String secretMessage = scanner.nextLine();
                file.createNewFile();
                try (Scanner writeScanner = new Scanner(file)) {
                    writeScanner.println(secretMessage);
                    try (Scanner readWriteScanner = new Scanner(file)) {
                        while (readWriteScanner.hasNext()) {
                            String readLine = readWriteScanner.nextLine();
                            System.out.println("Read from file after write: " + readLine);
                        }
                    }
                    file.delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}