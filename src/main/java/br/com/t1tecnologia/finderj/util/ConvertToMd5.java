/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author alexandre
 */
public class ConvertToMd5 {

    public static String CriptografaSenha(String senha) throws Exception {
        MessageDigest mdEnc = MessageDigest.getInstance("MD5");
        mdEnc.update(senha.getBytes(), 0, senha.length());
        return new BigInteger(1, mdEnc.digest()).toString(16);   
    }
}
