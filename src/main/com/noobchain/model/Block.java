package main.com.noobchain.model;

import main.com.noobchain.util.StringUtil;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // our data will be a simple message
    private  long timeStamp; //
    private int nonce;


    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash(){
        return StringUtil.
                applySha256(previousHash + Long.toString(timeStamp) + data);
    }

    public void mineBlock(int difficulty){
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
