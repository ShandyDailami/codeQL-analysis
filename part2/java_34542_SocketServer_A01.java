import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_34542_SocketServer_A01 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        int port = 8080;
        String hashAlgorithm = "MD5";
        Server server = new Server(port, hashAlgorithm);
        server.start();
    }

    static class Server extends Thread {
        private int port;
        private String hashAlgorithm;

        Server(int port, String hashAlgorithm) {
            this.port = port;
            this.hashAlgorithm = hashAlgorithm;
        }

        public void run() {
            try {
                Socket socket = new Socket("localhost", port);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("Connected to server");

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    String response = processRequest(message, hashAlgorithm);
                    writer.println(response);
                }
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String processRequest(String request, String hashAlgorithm) {
            // Simulating security sensitive operation
            try {
                MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
                byte[] digest = md.digest(request.getBytes());
                return bytesToHex(digest);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return "Error: Invalid hash algorithm";
            }
        }

        private String bytesToHex(byte[] bytes) {
            StringBuilder hexString = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }
    }
}