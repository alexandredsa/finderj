package br.com.t1tecnologia.finderj.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author alexandre
 */
public class ConvertToMd5 {

    public static String CriptografaSenha(String senha) throws NoSuchAlgorithmException   {
        MessageDigest mdEnc = MessageDigest.getInstance("MD5");
        mdEnc.update(senha.getBytes(), 0, senha.length());
        return new BigInteger(1, mdEnc.digest()).toString(16);   
    }
}
