import java.io.*;
import java.net.*;

public class java_32304_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 4445; // default port
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            e.printStackTrace();
       
        }
    }
}

class Handler extends Thread {
    private Socket socket;
    public java_32304_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String message, response;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                response = "Thank you for connecting to port " + socket.getPort();
                writer.writeBytes(response + "\n");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}