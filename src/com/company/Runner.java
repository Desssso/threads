package com.company;

import java.util.ArrayList;
import java.util.List;

public class Runner extends Thread {
    String name;
    Runner temp;
    int number;
    int count = 0;
    ArrayList<String> winner;
    String teamname;

    Runner(String name, Runner other, int number, ArrayList<String> winner, Team teamname){
        this.name = name;
        this.number = number;
        this.temp = other;
        this.winner = winner;
        this.teamname = teamname.name;
    }
    Runner(String name, int number){
        this.name = name;
        this.number = number;
        this.temp = null;
    }

    public void run(){
        try {
            if(temp != null){
                temp.join();
            }

            System.out.println(name+" начинает бежать");

            while (count<100){
                ++count;
                System.out.println(name + " пробежал "+ count+" метра(ов)");
                Thread.yield();
                Thread.sleep((long)(Math.random() * 10));
                if(number == 4 && count == 100){
                    winner.add(teamname);
                }
            }
        }catch (Exception e){}
    }
}
