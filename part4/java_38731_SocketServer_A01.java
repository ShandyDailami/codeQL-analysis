import java.io.*;
import java.net.*;

public class java_38731_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080); // Listening port
        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();

            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Create new thread for each connection
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_38731_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                // Handle the received line, e.g. check if it's a command to shutdown

                // Send response back to client
                out.writeBytes("Hello Client, you've sent: " + inputLine + "\n");
                out.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}