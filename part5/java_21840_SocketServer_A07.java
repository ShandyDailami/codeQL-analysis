import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_21840_SocketServer_A07 {
    private static final String PASSWORD = "securepassword";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocket socket = (SSLServerSocket) new SSLServerSocket(12345, 10000, false);
            socket.setNeedClientAuth(true);
            serverSocket = socket;
            SSLContext context = SSLContext.getInstance("SSL");
            context.init(null, new X509Certificate[] {}, null);
            serverSocket.setSSLContext(context);
            serverSocket.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Server failed to start.");
            System.exit(-1);
       
        }
        while (true) {
            Socket socketConnection = serverSocket.accept();
            if (socketConnection != null) {
                System.out.println("Accepted connection from: " + socketConnection.getRemoteSocketAddress());
                new SocketReader(socketConnection).start();
            }
        }
    }

    public static class SocketReader extends Thread {
        Socket socket;
        BufferedReader in = null;
        PrintWriter out = null;

        public java_21840_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.out.println("Error setting up I/O for socket reader.");
            }
        }

        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Authenticate the user and respond appropriately
                    if (message.equals(PASSWORD)) {
                        out.println("Authenticated successfully!");
                    } else {
                        out.println("Authentication failed!");
                    }
                    out.flush();
                }
                socket.close();
            } catch (IOException e) {
                System.out.println("Error handling socket.");
            }
        }
    }
}