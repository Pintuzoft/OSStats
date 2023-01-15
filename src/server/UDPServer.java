package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import core.HashNumeric;


/* Class ServSock listener for udp packets */
public class UDPServer extends HashNumeric {
    private DatagramSocket socket;
    private DatagramPacket packet;
    private int port;
    private int totalMessages = -1;
    private int pacSize = 8196;

    private boolean isRunning;

    /* Constructor */
    public UDPServer ( int inport ) {
        this.port = inport;
        isRunning = true;
        try {
            socket = new DatagramSocket ( port );
        } catch ( Exception e ) {
            System.out.println ( "Error: " + e.getMessage ( ) );
            System.exit(-1);
        }
        this.parse();
    }


    /* Method to parse the packets */
    private void parse ( ) {
        
        while ( isRunning ) {
            try {
                byte[] buf = new byte[pacSize];
                this.packet = new DatagramPacket ( buf, buf.length );
                this.socket.receive ( packet );
                String msg = new String ( packet.getData ( ) );
                System.out.println ( msg );
                this.socket.setSoTimeout(100);

            } catch ( Exception e ) {
                System.out.println ( "Error: " + e.getMessage ( ) );
            }
            
        }

    }

}
