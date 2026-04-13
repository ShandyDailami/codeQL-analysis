import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_03753_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // specify your directory here
        String integrityFailureDirectory = "/path/to/integrity_failure_directory";  // specify your integrity failure directory here

        File directory = new File(directoryPath);
        File integrityFailureDirectoryFile = new File(integrityFailureDirectory);

        if (directory.exists()) {
            scanDirectory(directory, integrityFailureDirectoryFile);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void scanDirectory(File directory, File integrityFailureDirectoryFile) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.canRead()) {
                        try {
                            MessageDigest md = MessageDigest.getInstance("SHA-256");
                            md.update(file.getBytes());

                            StringBuilder sb = new StringBuilder();
                            for (byte b : md.digest()) {
                                sb.append(String.format("%02x", b));
                            }

                            String fileHash = sb.toString();

                            if (fileHash.equals(fileIntegrity(integrityFailureDirectoryFile, file))) {
                                System.out.println("File " + file.getName() + " has integrity failure.");
                            }
                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("File " + file.getName() + " is not readable.");
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file, integrityFailureDirectoryFile);
                }
            }
        }
    }

    private static String fileIntegrity(File file, File integrityFailureDirectoryFile) {
        if (file.getAbsolutePath().equals(integrityFailureDirectoryFile.getAbsolutePath())) {
            return "";  // Return an empty string to indicate this file is the integrity failure file
        } else {
            return hashFile(file);
        }
    }

    private static String hashFile(File file) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(file.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : md.digest()) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}