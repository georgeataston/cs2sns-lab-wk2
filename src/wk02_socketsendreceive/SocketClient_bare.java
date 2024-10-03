package wk02_socketsendreceive;

import java.io.*;
import java.net.*;

public class SocketClient_bare {
    public static void main( String[] args ) throws IOException {
         
    	int portNumber = 17777;
    	String hostName = "127.0.0.1";

        System.out.println("Connecting....");
        Socket s;
        try {
            s = new Socket( hostName, portNumber );
            System.out.println("Connected.");
            System.out.println("Server: " + hostName + ":" + portNumber);
            System.out.println("Client: " + s.getLocalAddress() + ":" + s.getLocalPort());
            System.out.println("\nType 'quit' to disconnect.");
        } catch (Exception e) {
            System.out.println("Failed to connect: " + e.getMessage());
            return;
        }
        
        PrintWriter out = new PrintWriter( s.getOutputStream(), true );
        BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );

        BufferedReader userInput = new BufferedReader( new InputStreamReader(System.in) );

        String message = "";
        while (!s.isClosed()) {
            System.out.print("Message to send: ");
        	message = userInput.readLine();	//reads keyboard until user hits a newline
            out.println( message );
            if (message.equals("quit"))
                s.close();
        }

        System.out.println("Server disconnected.");
    }
}




