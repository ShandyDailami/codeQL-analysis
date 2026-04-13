import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_17561_SocketServer_A08 {
    private static SSLServerSocket serverSocket;
    private static DataInputStream input;
    private static DataOutputStream output;
    private static SSLContext sslContext;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            if (clientSocket.getState() == SSLSocket.CLOSED) {
                closeConnection(clientSocket);
            } else {
                input = new DataInputStream(clientSocket.getInputStream());
                output = new DataOutputStream(clientSocket.getOutputStream());

                // Send a response
                output.writeUTF("Hello, Client!");
                output.flush();

                // Close the connection
                closeConnection(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection(SSLSocket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}