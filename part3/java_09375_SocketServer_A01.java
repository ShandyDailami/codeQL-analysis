import java.io.*;
import java.net.*;

public class java_09375_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for connection on port " + 8080);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Connected to client at " + clientSocket.getRemoteSocketAddress());

        OutputStream outToClient = clientSocket.getOutputStream();
        PrintWriter out = new PrintWriter(outToClient, true);

        out.println("Hello, Client!");

        clientSocket.close();
        serverSocket.close();
    }
}