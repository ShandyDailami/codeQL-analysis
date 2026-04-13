import java.io.*;
import java.net.*;

public class java_00692_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000);
        while (true) {
            Socket socket = server.accept();
            System.out.println("A client connected");
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_00692_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Received: " + request);
                if (request.equals("exit")) {
                    writer.println("Exiting");
                    break;
                } else if (request.equals("error")) {
                    throw new Exception("An error occurred");
                } else {
                    writer.println("Response: " + request);
                }
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}