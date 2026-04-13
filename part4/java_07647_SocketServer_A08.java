import java.io.*;
import java.net.*;

public class java_07647_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080.");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connection established. Send 'quit' to exit.");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("quit")) {
                        out.writeUTF("Connection closed by client");
                        socket.close();
                        break;
                    }
                    out.writeUTF("Message received. Send another message or 'quit' to exit.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}