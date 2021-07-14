package com.company;

import java.util.ArrayList;
import java.util.List;

public class Relay extends Thread {
    List<Team> teamname = new ArrayList<>();
    int count = 0;
    ArrayList<String> winner = new ArrayList<>();

    Relay(String[] teamNames,String[][] teamRunners){
        for(String temp : teamNames){
            Team team = new Team();
            team.name = temp;
            for(int i = 0; i<4;i++){
                team.runnername.add(teamRunners[count][i]);
            }
            teamname.add(team);
            count++;
        }
    }

    public void run(){
        try {
            for(Team team : teamname){
                Runner r1 = new Runner(team.runnername.get(0),1);
                Runner r2 = new Runner(team.runnername.get(1),r1,2,winner,team);
                Runner r3 = new Runner(team.runnername.get(2),r2,3,winner,team);
                Runner r4 = new Runner(team.runnername.get(3),r3,4,winner,team);
                r1.start();
                r2.start();
                r3.start();
                r4.start();
            }
            Thread.sleep(3000);
            System.out.println(winner.get(0));
        }catch (Exception e){}
    }

}
