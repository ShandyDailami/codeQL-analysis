import java.io.*;
import java.net.*;

public class java_36604_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started.");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected.");

                // Handle client here using threads
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_36604_SocketServer_A07(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;

        try {
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Perform authentication here using standard libraries
                // For the purpose of this example, let's just check if the message
                // contains the word "password" and respond with a message if it does
                if (message.contains("password")) {
                    out.println("Access denied.");
                } else {
                    out.println("Access granted.");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}