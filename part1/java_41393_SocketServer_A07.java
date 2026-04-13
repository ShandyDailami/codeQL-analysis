import java.net.*;
import java.io.*;
import java.util.*;

public class java_41393_SocketServer_A07 {

    private static final int PORT = 12345;
    private static final String AUTH_FAILURE_KEY = "A07_AuthFailure";

    private static String readAuthFailureKey(Socket s) throws IOException {
        try (DataInputStream dis = new DataInputStream(s.getInputStream())) {
            return dis.readUTF();
        }
    }

    private static boolean authenticate(Socket s) {
        try {
            String key = readAuthFailureKey(s);
            return AUTH_FAILURE_KEY.equals(key);
        } catch (IOException e) {
            System.out.println("Authentication failure: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket sock = server.accept();
            System.out.println("Connection accepted from: " + sock.getRemoteSocketAddress());

            if (authenticate(sock)) {
                System.out.println("Authenticated!");
                new SecureClientHandler(sock).start();
            } else {
                System.out.println("Authentication failed!");
                sock.close();
            }
        }
    }

    static class SecureClientHandler extends Thread {
        private Socket sock;

        public java_41393_SocketServer_A07(Socket sock) {
            this.sock = sock;
        }

        public void run() {
            try (DataOutputStream dos = new DataOutputStream(sock.getOutputStream())) {
                dos.writeUTF(AUTH_FAILURE_KEY);
            } catch (IOException e) {
                System.out.println("Error in sending data: " + e.getMessage());
            }
            sock.close();
        }
    }
}