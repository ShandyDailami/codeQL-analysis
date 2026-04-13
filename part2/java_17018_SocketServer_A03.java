import java.io.*;
import java.net.*;

public class java_17018_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // read client message
            String clientMessage = dataInputStream.readUTF();

            // check if it is safe from injection attacks
            if (isSafeFromInjectionAttack(clientMessage)) {
                System.out.println("Message from client: " + clientMessage);

                // write back to client
                dataOutputStream.writeUTF("Server: " + clientMessage);
                dataOutputStream.flush();
            }

            socket.close();
        }
    }

    private static boolean isSafeFromInjectionAttack(String message) {
        // Add your code to check if there's a possible injection attack here
        // For now, we assume that if the message contains 'DROP' or 'DELETE' or 'UPDATE' it's safe
        return message.contains("DROP") || message.contains("DELETE") || message.contains("UPDATE");
    }
}