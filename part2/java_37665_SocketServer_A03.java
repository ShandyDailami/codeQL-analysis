import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_37665_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                sslSocket = sslServerSocket.accept();
                new Handler(sslSocket).start();
            }
        } finally {
            sslServerSocket.close();
            sslSocket.close();
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;
        private final SSLSocket sslSocket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_37665_SocketServer_A03(Socket socket) {
            this.socket = socket;
            this.sslSocket = (SSLSocket) socket.getSocket();
            this.in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            this.out = new PrintWriter(sslSocket.getOutputStream(), true);
        }

        public void run() {
            try {
                out.println("Hello from server!");
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Simulate injection here.
                    if (message.equals("inject this")) {
                        System.out.println("Attempting injection...");
                        // Inject a random byte array
                        sslSocket.write(new byte[]{(byte) (Math.random() * 256)});
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}