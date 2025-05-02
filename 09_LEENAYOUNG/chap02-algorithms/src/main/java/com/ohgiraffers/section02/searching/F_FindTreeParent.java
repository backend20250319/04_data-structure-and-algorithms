package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class F_FindTreeParent {

    static int N;                   // 노드의 개수
    static List<Integer>[] list;    // 연결 노드 저장 배열 (희소 그래프이므로 리스트 사용)
    static int[] parent;            // 최종 결과 저장 배열
    static boolean[] visited;       // 방문 결과 저장 배열

    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        //dfs(1);
        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append(" ");
        }

        return sb.toString();
    }

    static void dfs(int rootNode) {

        visited[rootNode] = true;

        for (int childNode : list[rootNode]) {
            if (!visited[childNode]) {
                dfs(childNode);
                parent[childNode] = rootNode;
            }
        }
    }

    static void bfs(int root) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;

        while(!queue.isEmpty()) {
            int rootNode = queue.poll();

            for (int childNode : list[rootNode]) {
                if (!visited[childNode]) {
                    visited[childNode] = true;
                    queue.offer(childNode);
                    parent[childNode] = rootNode;
                }
            }
        }
    }
}
