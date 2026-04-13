import java.io.*;
import java.net.*;

public class java_37948_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client is connected");

            // create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_37948_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // create input and output streams
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            // read client message
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // send back to client a response
            writer.writeBytes("Hello, client!" + "\n");
            writer.flush();

            // close the connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}