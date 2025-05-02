package com.ohgiraffers.section07.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Practice2 {

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int price;

        Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        // 무게 오름차순, 무게가 같으면 가격 내림차순 정렬
        @Override
        public int compareTo(Jewelry o) {
            if(this.weight == o.weight)
                return o.price - this.price;
            return this.weight - o.weight;
        }
    }

    public long solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewelry(weight, price);
        }

        Arrays.sort(jewelries);

        int[] bags = new int[N];
        for (int i = 0; i < N; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            while(j < M) {
                if(jewelries[j].weight > bags[i]) {
                    break;
                }
                pq.add(jewelries[j++].price);
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        return result;
    }
}