import java.io.*;
import java.net.*;
import java.util.*;

public class java_32311_SocketServer_A07 {
    private static List<String> whitelist = Arrays.asList("10000", "10001", "10002");

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(0);
            System.out.println("Server is listening on port " + serverSocket.getLocalPort());
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected.");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String clientAddress = dis.readUTF();
                if (whitelist.contains(clientAddress)) {
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                    pw.println("Hello, client!");
                } else {
                    System.out.println("Client " + clientAddress + " is not allowed to connect.");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}