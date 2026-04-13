import java.io.*;
import java.net.*;

public class java_31273_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Here, we are using a very simple client-server authentication 
                // For real world applications, you should use SSL/TLS for secure communication 
                // and handle authentication at the server side.
                String clientHello = input.readUTF();
                if ("Hello, Client!".equals(clientHello)) {
                    output.writeUTF("Hello, Server!");
                    output.flush();
                } else {
                    output.writeUTF("Unauthorized access!");
                    output.flush();
               
                    socket.close();
                    continue;
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}