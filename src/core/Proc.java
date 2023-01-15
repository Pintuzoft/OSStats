package core;

import server.UDPServer;

public class Proc extends HashNumeric {
    private static UDPServer server;

    public Proc ( ) {
        
        System.out.println("Mohaha!");
        server = new UDPServer ( 27500 );
        
    }
}
