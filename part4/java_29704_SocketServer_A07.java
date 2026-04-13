import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_29704_SocketServer_A07 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) {

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                SSLSession session = clientSocket.getSession();
                System.out.println("Session created " + session.getCreationTime() +
                        " Session ID " + session.getId() +
                        " Session state " + session.getState());

                OutputStream out = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello Client, you are authenticated");

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}