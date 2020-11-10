package com.haoran.algorithems;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicReference;

public class Hanoi {

    public static void main(String[] args) throws IOException {

        System.out.println(ssss(40));
        System.out.println(xxxx(40));
        System.out.println(feibonaqie(40));
        System.out.println(count1+","+count2);
       /* BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\haoran\\Desktop\\快搜招标分析.txt", true));

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\haoran\\Desktop\\快搜招标分析_20200722092610.txt"));
        String c;
        while ((c = reader.readLine()) != null) {
            c = decodeUnicode(c);
            System.out.println(c);

            out.write(c + "\n");
        }
        out.flush();
        out.close();
        reader.close();*/
    }

    public static String decodeUnicode(final String unicode) {
        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 0; i < hex.length; i++) {

            try {
                // 汉字范围 \u4e00-\u9fa5 (中文)
                if (hex[i].length() >= 4) {//取前四个，判断是否是汉字
                    String chinese = hex[i].substring(0, 4);
                    try {
                        int chr = Integer.parseInt(chinese, 16);
                        boolean isChinese = isChinese((char) chr);
                        //转化成功，判断是否在  汉字范围内
                        if (isChinese) {//在汉字范围内
                            // 追加成string
                            string.append((char) chr);
                            //并且追加  后面的字符
                            String behindString = hex[i].substring(4);
                            string.append(behindString);
                        } else {
                            string.append(hex[i]);
                        }
                    } catch (NumberFormatException e1) {
                        string.append(hex[i]);
                    }

                } else {
                    string.append(hex[i]);
                }
            } catch (NumberFormatException e) {
                string.append(hex[i]);
            }
        }

        return string.toString();
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    private static int nnn(int x) {
        if (x == 1) {
            return 1;
        }
        return x * nnn(x - 1);
    }

    private static List<Integer> xxx() {
        List<Integer> list = new ArrayList<>();
        for (int i = 101; i < 200; i += 2) {
            boolean iszhishu = true;
            for (int j = 3; j < i; j++) {
                if (i % j == 0) {
                    iszhishu = false;
                    break;
                }
            }
            if (iszhishu) {
                list.add(i);
            }
        }
        return list;
    }

    static int count1 = 0;
    static int count2 = 0;
    static HashMap<Integer,Integer> map = new HashMap<>();
    private static int ssss(int i){
        if(map.containsKey(i)){
            return map.get(i);
        }
        count1++;
        if(i<3){
            return 1;
        }
        int res = ssss(i-1)+ssss(i-2);
        map.put(i,res);
        return  res;
    }

    //102334155
    private  static int  xxxx(int index){
        if(index < 3){
            return 1;
        }
        int[] res = new int[]{1,1,0};
        for (int i=3;i<=index;i++){
            count2++;
            res[2] = res[0] + res[1];
            res[0] = res[1];
            res[1] = res[2];
        }
        return res[2];
    }

    private static int feibonaqie(int index){
        int res = 1;
        int last = 0;
        int tmp;
        for(int i=2;i<=index;i++){
            tmp = res;
            res = res+last;
            last = tmp;
        }
        return res;
    }
}
