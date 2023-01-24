package com.company;

public class KrolikiDyn {

    public static void main(String[] args) {
        kroliki();
    }

    public static void kroliki(){
        final int N = 13;
        int[] tab = new int[N];
        tab[0] = 1;
        tab[1] = 1;

        for(int i=2;i<tab.length;i++) {
            tab[i] = tab[i-1] + tab[i-2];
        }
        System.out.println(tab[N-1]);
    }
}
