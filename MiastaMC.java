package com.company;

import java.util.Random;

public class MiastaMC {
    public static void main(String[] args) {
        miasto();

    }

    public static int miasto(){
        final int[][] costs = {
                {0, 300, 402, 356, 0, 0, 0, 0, 0},
                {300, 0, 0, 0, 440, 474, 0, 0, 0},
                {402, 0, 0, 0, 0, 330, 0, 0, 0},
                {356, 0, 0, 0, 0, 0, 823, 0, 0},
                {0, 440, 0, 0, 0, 0, 0, 430, 0},
                {0, 474, 330, 0, 0, 0, 813, 365, 774},
                {0, 0, 0, 823, 0, 813, 0, 0, 403},
                {0, 0, 0, 0, 430, 365, 0, 0, 768},
                {0, 0, 0, 0, 0, 774, 403, 768, 0}

                //{0, 300, 402, 356, 999, 999, 999, 999, 999},
                //{300, 0, 999, 999, 440, 474, 999, 999, 999},
                //{402, 999, 0, 999, 999, 330, 999, 999, 999},
                //{356, 999, 999, 0, 999, 999, 823, 999, 999},
                //{999, 440, 999, 999, 0, 999, 999, 430, 999},
                //{999, 474, 330, 999, 999, 0, 813, 365, 774},
                //{999, 999, 999, 823, 999, 813, 0, 999, 403},
                //{999, 999, 999, 999, 430, 365, 999, 0, 768},
                //{999, 999, 999, 999, 999, 774, 403, 768, 0}

                //{0, 300, 402, 356, 0, 0, 0, 0, 0},
                //{300, 0, 0, 0, 440, 474, 0, 0, 0},
                //{402, 0, 0, 0, 0, 330, 0, 0, 0},
                //{356, 0, 0, 0, 0, 0, 823, 0, 0},
                //{0, 440, 0, 0, 0, 0, 0, 430, 0},
                //{0, 474, 330, 0, 0, 0, 813, 365, 774},
                //{0, 0, 0, 823, 0, 813, 0, 0, 403},
                //{0, 0, 0, 0, 430, 365, 0, 0, 768},
                //{0, 0, 0, 0, 0, 774, 403, 768, 0}
        };
        int miasta = costs.length;
        int[] bestSeq = new int[miasta+1];
        int bestValue = Integer.MAX_VALUE;

        final int attempts=10;
        Random rand = new Random();

        for(int i=0; i<attempts;i++) {

            //losujemy 1 smak
            int start = rand.nextInt(9);
            int[] curSeq = new int[miasta+1];
            curSeq[0] = start;

            boolean[] selected = new boolean[miasta];
            selected[start] = true;
            int selectdCount = 1;
            //losujemy kolejne smaki
            while (selectdCount < miasta) {
                int x = rand.nextInt(9);
                if (selected[x]) continue; //Jeśli sie powtórzył to losuj inny
                curSeq[selectdCount] = x;
                selected[x] = true;
                selectdCount++;
            }
            //Wracamy do początkowego smaku
            curSeq[9] = start;

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
        System.out.println("Kolejność miast: ");
        for(int i = 0; i<bestSeq.length;i++){
            System.out.println(""+(bestSeq[i]+1));
        }
        System.out.println("Całkowita pokonana droga: "+bestValue);

        return bestValue;

    }
}
