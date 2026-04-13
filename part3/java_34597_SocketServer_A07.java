import java.io.*;
import java.net.*;

public class java_34597_SocketServer_A07 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        try {
            // Step 1: Initialize ServerSocket
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started.");

            // Step 2: Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Step 3: Communicate with client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 4: Create a thread to handle client
            Thread thread = new Thread() {
                public void run() {
                    try {
                        // Step 5: Get the message from client
                        String message = in.readUTF();
                        System.out.println("Received: " + message);

                        // Step 6: Send a message back to client
                        out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!");
                        out.flush();

                        // Step 7: Close the connection
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            // Step 8: Start the thread
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}