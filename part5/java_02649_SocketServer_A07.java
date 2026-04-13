import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class java_02649_SocketServer_A07 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Add BouncyCastle provider
        java.security.Security.addProvider(new BouncyCastleProvider());

        ServerSocket serverSocket = null;
        while (true) {
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            // Handle the connection here
            // For example, start a new thread to handle the client
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_02649_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle client connection and communication here
    }
}