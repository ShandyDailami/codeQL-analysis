import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_36659_SocketServer_A07 {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/CBC/PKCS5Padding";
    private static SecretKey secretKey = new SecretKeySpec("ThisKeyIsUsedToEncryptAndDecrypt".getBytes(), ALGORITHM);

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted");
            new ServerThread(socket).start();
        }
    }

    static class ServerThread extends Thread {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        ServerThread(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                System.out.println("Exception occured while setting up I/O streams");
                e.printStackTrace();
            }
        }

        public void run() {
            String clientMessage;
            try {
                clientMessage = in.readLine();
                System.out.println("Received: " + clientMessage);
                if (authenticate(clientMessage)) {
                    out.println("Auth successful");
                } else {
                    out.println("Auth failure");
               
                }
            } catch (IOException e) {
                System.out.println("Exception occurred while reading/writing to the stream");
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Exception occurred while closing the stream");
                    e.printStackTrace();
                }
            }
        }

        private boolean authenticate(String message) {
            byte[] decoded = javax.crypto.Cipher.getInstance(TRANSFORMATION).doFinal(Base64.getDecoder().decode(message));
            return new String(decoded).equals(secretKey);
        }
    }
}