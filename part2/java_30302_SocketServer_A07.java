import java.io.*;
import java.net.*;
import java.util.*;

public class java_30302_SocketServer_A07 {
    private static final String PORT_STRING = "8888";
    private static ServerSocket serverSocket;

    private java_30302_SocketServer_A07() {
    }

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(Integer.parseInt(PORT_STRING));
            System.out.println("Server is running on port " + PORT_STRING);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                out.writeUTF("Message received");
                out.flush();
                System.out.println("Sent message: " + "Message received");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}