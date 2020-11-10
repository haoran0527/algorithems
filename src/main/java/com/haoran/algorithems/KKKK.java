package com.haoran.algorithems;

public class KKKK {
    public static void main(String[] args) {
        String s = "12341231";
        System.out.println(test(s));
    }

    private static int test(String s){
        int count = 0;
        if(s.length()<2){
            return 1;
        }
        String s0 = s.charAt(0)+"";
        int i0 = Integer.parseInt(s0);
        String s1 = s.charAt(1)+"";
        int i1 = Integer.parseInt(s1);
        if(i0>2){
            count += test(s.substring(1));
        }else if(i0 == 2 && i1 > 6){
            count += test(s.substring(1));
        }else{
            count = count +test(s.substring(2))+test(s.substring(1));
        }
        System.out.println(s+":"+count);
        return count;
    }
}
