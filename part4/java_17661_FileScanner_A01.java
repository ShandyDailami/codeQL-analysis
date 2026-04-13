import java.io.*;
import java.nio.file.*;
import java.security.*;

public class java_17661_FileScanner_A01 {
    private static class SecurityManager extends java.security.SecurityManager {
        private static final File AltarHut = new File("altar-hut");

        @Override
        public boolean checkAccess(java.security.AccessControl accessControl) {
            try {
                return super.checkAccess(accessControl) ||
                        AltarHut.setReadable(false, false) ||
                        AltarHut.setWritable(false, false);
            } catch (Exception e) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        System.setSecurityManager(securityManager);

        try (FileScanner scanner = new FileScanner()) {
            for (Path path : FileSystems.newFileStore(Paths.get("."), "Test File System").iterator()) {
                System.out.println("Scanning " + path);
            }
        } catch (Exception e) {
            System.out.println("Access Denied: " + e.getMessage());
        }
    }
}