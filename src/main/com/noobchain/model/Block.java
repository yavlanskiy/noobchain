package noobchain.model;

import java.util.Date;

public class Block {
    public String hash;
    public  String previousHash;
    private String data; // our data will be a simple message
    private  long timeStamp; //

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
    }
}
