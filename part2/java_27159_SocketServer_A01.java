import java.io.*;
import java.net.*;

public class java_27159_SocketServer_A01 {

    public static void main(String[] args) {

        // create a server socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort());

            while (true) {
                // accept a connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

                // create a new thread for each client
                Thread newThread = new Thread(new SocketHandler(clientSocket));
                newThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close the server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_27159_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String message;
        try {
            // receive a message
            message = in.readLine();
            System.out.println("Received: " + message);

            // send a response
            out.println("Server received your message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}