import java.io.*;
import java.net.*;

public class java_32040_SocketServer_A01 {
    private static boolean running = true;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234.");

            while(running) {
                Socket socket = serverSocket.accept();
                System.out.println("A client is connected.");

                // Here, the server is setting up a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_32040_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Here, the server is checking if the received message is a command for disconnection
                if(message.equalsIgnoreCase("DISCONNECT")) {
                    writer.println("Disconnected successfully.");
                    socket.close();
                    System.out.println("Disconnected from the client.");
                    break;
                }

                // Here, the server is demonstrating a way to break the system
                if(message.equalsIgnoreCase("BREAK")) {
                    throw new RuntimeException("This is a demonstration of broken access control.");
                }

                writer.println("Server received: " + message);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } catch(RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}