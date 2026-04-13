import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_06100_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        boolean useSSL = true;
        int port = 8000;

        if (useSSL) {
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
            Socket sslSocket = sslServerSocket.accept();
            System.out.println("Client connected via SSL");
            handleSSL(sslSocket);
        } else {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);
            handle(serverSocket);
        }
    }

    private static void handle(ServerSocket serverSocket) throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        OutputStream out = socket.getOutputStream();

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.write((inputLine + "\n").getBytes());
            out.flush();
        }

        socket.close();
    }

    private static void handleSSL(Socket socket) throws IOException {
        SSLServerSocket sslServerSocket = (SSLServerSocket) socket.getSocket();
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        System.out.println("Client connected via SSL");
        handleClient(sslSocket);
    }
}