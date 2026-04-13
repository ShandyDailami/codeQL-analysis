import java.io.*;
import java.net.*;

public class java_04762_SocketServer_A01 {

    public static void main(String[] args) {

        // define the port number to listen on
        int port = 9999;

        // create a server socket
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server is listening on port " + port);

            // start accepting connections
            while (true) {
                Socket socket = serverSocket.accept();

                // create a new thread for each connection
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_04762_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String clientMessage;

            // read from the client and print the message
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // send a response back to the client
                out.println("Server received your message: " + clientMessage);
            }

            // close the connection
            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}