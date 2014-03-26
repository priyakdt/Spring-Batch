package com.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
/**
 * 
 * @author skadati
 *
 */
public class PasswordEncryptor {
/**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) throws Exception {
        String password = " ";
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");

        SystemEnvUtils se = new SystemEnvUtils();
        standardPBEStringEncryptor.setPassword(System.getenv("APP_ENCRYPTION_PASSWORD"));
        System.out.println("System Env Variable :" + System.getenv("APP_ENCRYPTION_PASSWORD"));
        System.out.println("Text Password :" + password);
        
        String myEncrypted = standardPBEStringEncryptor.encrypt(password);
        System.out.println("Encrypted Password :" + myEncrypted);
        //Test decryption
        StandardPBEStringEncryptor standardPBEStringEncryptor1 = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor1.setAlgorithm("PBEWithMD5AndDES");
        standardPBEStringEncryptor1.setPassword(System.getenv("APP_ENCRYPTION_PASSWORD"));
        String myDecrypted = standardPBEStringEncryptor1.decrypt(myEncrypted);
        System.out.println("Decrypted Password :" + myDecrypted);
    }
}