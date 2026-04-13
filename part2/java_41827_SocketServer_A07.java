import java.io.*;
import java.net.*;
import java.util.*;

public class java_41827_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                String clientInput = in.readUTF();
                String[] inputs = clientInput.split(" ");
                
                if (inputs[0].equals("auth")) {
                    if (inputs.length != 3) {
                        out.writeUTF("auth failed, incorrect number of arguments");
                    } else {
                        if (inputs[1].equals(USERNAME) && inputs[2].equals(PASSWORD)) {
                            out.writeUTF("auth succeeded");
                        } else {
                            out.writeUTF("auth failed, incorrect username or password");
                        }
                    }
                } else {
                    out.writeUTF("unknown command");
                }
                
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}