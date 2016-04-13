package com.my.heap;

import java.io.IOException;
import java.util.Random;

public class Main {
    
    public static void init(Heap h){
        Random r = new Random();
        for (int i = 0; i < 15; i++)
            h.insert((int) (r.nextDouble()*100));
    }
    
    public static void main(String[] args) throws IOException{
        int value;
        Heap h = new Heap(16);
        init(h);
        while (true){
            h.show();
            System.out.println("Доступны команды: add, move, change");
            String choice = Input.getStr();
            switch(choice){
                case "add":
                    System.out.print("Введите значение: ");
                    value = Input.getInt();
                    if ((!h.insert(value))&&(value != -1)){
                        System.out.println("Очередь заполнена!");
                    }
                    break;
                case "move":
                    if (h.isEmpty()){
                        System.out.println("Очерель пуста!");
                    }
                    else
                    {
                        h.remove();
                    }
                    break;
                case "change":
                    System.out.print("Введите порядковый номер элемента в очереди: ");
                    value = Input.getInt();
                    System.out.print("Введите его новое значение: ");
                    int newValue = Input.getInt();
                    if ((!h.change(value, newValue))&&(newValue != -1)){
                        System.out.println("Элемента под этим номером нет!");
                    }
                    break;
                default:
                    System.out.println(choice + " - Эта команда недоступна!");
            }
        }
    } 
}
