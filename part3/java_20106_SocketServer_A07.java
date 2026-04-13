import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_20106_SocketServer_A07 {

    private static final String ALGORITHM = "AES";
    private SecretKey key;

    public java_20106_SocketServer_A07() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        key = keyGenerator.generateKey();
    }

    public class EchoServerThread extends Thread {

        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public java_20106_SocketServer_A07(Socket s) {
            socket = s;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.out.println("Error occurred while setting up communication stream.");
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                out.println("Server is ready.");
                String message;
                while ((message = in.readLine()) != null) {
                    out.println("Received: " + message);
                    if (message.equals("auth fail")) {
                        System.out.println("Auth Failure detected, closing connection.");
                        out.println("Auth Failure");
                        socket.close();
                        System.out.println("Connection closed.");
                    } else {
                        out.println("Processed: " + process(message));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error occurred while handling client communication.");
                e.printStackTrace();
            }
        }

        private String process(String message) {
            // TODO: Implement authentication process
            return message;
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServer().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}