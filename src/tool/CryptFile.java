package tool;

import java.io.*;
import java.security.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class CryptFile{ 

    private home nt;
    static File file;
    
    public final static int ENCRYPT = Cipher.ENCRYPT_MODE;
    public final static int DECRYPT = Cipher.DECRYPT_MODE;
    
    public CryptFile(String filePath,home nt){
        this.nt = nt;
        file = new File(filePath);
        
    }
    
    public void cryptStart(int mode){
        var displaySize = Need.byteSizing((int)file.length());
        
        nt.terminal.setText((nt.outText += String.format("\n%s - [%s] ",file.getName(),displaySize )));
        var thread = Need.progressAni(nt);
        
        crypt(mode, file, file);
        thread.stop();
    }
    
    public boolean isExists(){
        return file.exists();
    }
    
    public long size(){
        return file.length();
    }
    
    public String getFullPath(){
        return file.getAbsolutePath();
    }
    
    
    /**
     * @see crypt
     * this section is for operation of cryption to encrypt the file nor decrypt file
     */
    //----------------------------------------
    private final static String ALGORITHM = "AES";//advance encryption standard
    private final static String TRANSFORMATION = "AES/ECB/PKCS5PADDING";
    private final static String PASSKEY = "~cryptblack!isaac#";//warning: do not try to edit this password if you are not a developer
    //----------------------------------------
    private String crypt(int cripherMode,File inputFile,File outputFile){
        var getCryptFileFullPath = "";
        var repeat = false;
        
        if(cripherMode == Cipher.DECRYPT_MODE){
            repeat = true;
        }
        
        do{
            
            try {
                if(inputFile.length() == 0){
                    throw new IOException("file Empty!");//to make sure the file is not empty  
                }
                

                //create secret key
                MessageDigest sha = MessageDigest.getInstance("SHA-512");
                var key = PASSKEY.getBytes("UTF-8");//convert to array bytes UTF-8
                    key = sha.digest(key);
                    key = Arrays.copyOf(key, 16);
                //--------------------------
                
                var secretKey = new SecretKeySpec(key,ALGORITHM);
                var cripher = Cipher.getInstance(TRANSFORMATION);
                
                var inputStream = new FileInputStream(inputFile);
                var inputBytes = new byte[(int)inputFile.length()];
                inputStream.read(inputBytes);
                inputStream.close();

                var outputStream = new FileOutputStream(outputFile);
                byte[] out;
    
                try{
                    cripher.init(cripherMode, secretKey);
                    out = cripher.doFinal(inputBytes);//change the data 
                }catch(IllegalBlockSizeException e){
                    out = inputBytes;
                    repeat = false;//stop the loop
                }
                
                outputStream.write(out);
                outputStream.close();
                
    
                getCryptFileFullPath = outputFile.getAbsolutePath();//set encrypted or decrypted file absolute path 
    
            } catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IOException | BadPaddingException | OutOfMemoryError e) {
                if(e.getMessage().toLowerCase().equals("Java heap space")){
                    
                }else if(e.getMessage().equals("file Empty!")){
                    return getCryptFileFullPath;
                }
                error = e.getMessage();
            }
        }while(repeat);//repeat to decrypting multiple encryption
        return getCryptFileFullPath;
    }
    
    private String error = null;
    public String getErrorMSG(){
        return error;
    }
}
