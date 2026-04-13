import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_36544_SocketServer_A01 {
    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;
    private static SSLContext sslContext;

    public static void main(String[] args) {
        init();
        acceptClients();
        close();
    }

    private static void init() {
        try {
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptClients() {
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
                sslSocket.startHandshake();
                System.out.println("Client accepted!");
                // Now you can write and read the data
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void close() {
        try {
            serverSocket.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}