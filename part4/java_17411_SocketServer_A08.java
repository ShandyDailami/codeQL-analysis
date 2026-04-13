import java.io.*;
import java.net.*;

public class java_17411_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // create a new thread to handle the client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_17411_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            String message = dataInputStream.readUTF();
            System.out.println("Received: " + message);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // send a response back to the client
            String response = "Hello, client!";
            dataOutputStream.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}