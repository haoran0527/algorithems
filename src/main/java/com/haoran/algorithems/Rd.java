package com.haoran.algorithems;

import java.util.*;

public class Rd {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDDR"));
    }
    public static String predictPartyVictory(String senate) {
        char c = senate.charAt(0);
        if(c=='D'){
            int index = senate.indexOf("R");
            if(index<0){
                return "Dire";
            }else{
                senate = senate.substring(1).replaceFirst("R","")+"D";
            }
        }else{
            int index = senate.indexOf("D");
            if(index<0){
                return "Radiant";
            }else{
                senate = senate.substring(1).replaceFirst("D","")+"R";
            }
        }
        return predictPartyVictory(senate);
    }
}
