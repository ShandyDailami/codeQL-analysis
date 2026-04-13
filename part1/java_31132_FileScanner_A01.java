import java.io.*;

public class java_31132_FileScanner_A01 {
    private static final String SECURITY_PREVENTION_LOG = "Security prevention log: Access to file '%s' has been restricted due to lack of proper authorization.";

    public static void main(String[] args) {
        File directory = new File("/path/to/directory");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        FileReader reader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(reader);
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            // FileScanner logic here
                            // Security-sensitive operation related to A01_BrokenAccessControl goes here.
                            // Example:
                            System.out.println(SECURITY_PREVENTION_LOG + file.getPath());
                        }
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}