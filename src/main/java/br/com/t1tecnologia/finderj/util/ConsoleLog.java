package br.com.t1tecnologia.finderj.util;

import br.com.t1tecnologia.finderj.enums.ConsoleColorsEnum;
import java.text.MessageFormat;

/**
 *
 * @author alexandre
 */
public class ConsoleLog {

    public static void write(String uri, Class clazz, String metodo, ConsoleColorsEnum color) {
        String strColor = color.getCode();
        String classe = clazz.toString();
        System.out.println(MessageFormat.format("{0}classe:{1} \n {0}método:{2} \n {0}URI: {3}", strColor, classe, metodo, uri));

    }

    public static void write(String uri, Class clazz, String metodo) {
        write(uri, clazz, metodo, ConsoleColorsEnum.ANSI_RED);
    }
    
    public static void writeString(String text){
        System.out.println(MessageFormat.format("{0} LOG:{1}",ConsoleColorsEnum.ANSI_RED.getCode(),text));
    }

}
