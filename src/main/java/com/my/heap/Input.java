package com.my.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public static String getStr() throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(in);
        return buf.readLine();
    }
    
    public static char getChar() throws IOException{
        return getStr().charAt(0);
    }
    
    public static int getInt(){
        try {
            int x = Integer.parseInt(getStr());
            if (x < 0) System.out.println("Недопустимое значение!");
            return x;
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Ошибка ввода");
            return -1;
        }
    }
}
