import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_38420_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        // create a socket server on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);
        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.accept();

        // create a SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] { new X509TrustManager() }, null);

        // wrap the socket with SSL
        SSLSocket sslSocket = (SSLSocket) sslContext.wrapSocket(sslServerSocket);

        // start accepting client connections
        while (true) {
            Socket clientSocket = sslSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            // create a new thread for the client
            new Handler(clientSocket).start();
        }
    }
}

class Handler extends Thread {
    Socket socket;

    public java_38420_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // read from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();

            // write back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello, client, you connected with message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}