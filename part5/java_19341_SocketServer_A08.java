import java.io.*;
import java.net.*;

public class java_19341_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client connected");

            // Start a new thread to handle communication with the client
            new HandlerThread(socket).start();
        }
    }
}

class HandlerThread extends Thread {
    private Socket socket;

    public java_19341_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Simulate a security-sensitive operation related to integrity failure
                if (clientMessage.equals("A08_IntegrityFailure")) {
                    out.println("ERROR: Security violation - Denying access!");
                    out.flush();
                    System.out.println("Sent: " + out.toString());
                } else {
                    out.println("OK: Processed: " + clientMessage);
                    out.flush();
                    System.out.println("Sent: " + out.toString());
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}