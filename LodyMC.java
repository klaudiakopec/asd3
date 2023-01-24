package com.company;

import java.util.Random;

public class LodyMC {


    public static void main(String[] args) {
        lody();

    }

    public static int lody(){
        final int[][] costs = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };
        int flavors = costs.length;
        int[] bestSeq = new int[flavors+1];
        int bestValue = Integer.MAX_VALUE;

        final int attempts=10;
        Random rand = new Random();

        for(int i=0; i<attempts;i++) {

            //losujemy 1 smak
            int start = rand.nextInt(6);
            int[] curSeq = new int[flavors+1];
            curSeq[0] = start;

            boolean[] selected = new boolean[flavors];
            selected[start] = true;
            int selectdCount = 1;
            //losujemy kolejne smaki
            while (selectdCount < flavors) {
                int x = rand.nextInt(6);
                if (selected[x]) continue; //Jeśli sie powtórzył to losuj inny
                curSeq[selectdCount] = x;
                selected[x] = true;
                selectdCount++;
            }
            //Wracamy do początkowego smaku
            curSeq[6] = start;

            //obliczanie wartości dla danej sekwencji
            int curValue = 0;
            for (int j = 0; j < curSeq.length - 1; j++) {
                curValue += costs[curSeq[j]][curSeq[j + 1]];
            }
            //zapisujemy najlepsze wartości
            if (curValue < bestValue) {
                bestValue = curValue;
                bestSeq = curSeq;
            }
        }
        //Wypisanie wyniku
        System.out.println("Najlepsze rozwiązanie");
        System.out.println("Smaki: ");
        for(int i = 0; i<bestSeq.length;i++){
            System.out.println(""+(bestSeq[i]+1));
        }
        System.out.println("Całkowity czas przestrojeń: "+bestValue);

        return bestValue;

    }

}
