package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_TreeTraversal {

    // 각 노드(알파벳 A~Z)의 왼쪽, 오른쪽 자식을 저장하는 배열(-1이면 자식 없음)
    static int[] left;
    static int[] right;
    static StringBuilder sb;

    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        int N = Integer.parseInt(br.readLine());

        left = new int[26];
        right = new int[26];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            int index = parent - 'A';
            if (leftChild != '.') left[index] = leftChild - 'A';
            if (rightChild != '.') right[index] = rightChild - 'A';
        }

        sb = new StringBuilder();

        // 전위 순위(PreOrder)
        preOrder(0);
        sb.append("\n");

        // 중위 순위(InOrder)
        inOrder(0);
        sb.append("\n");

        // 후위 순위(PostOrder)
        postOrder(0);

        return sb.toString();
    }

    private static void preOrder(int node) {
        if (node == -1) return;
        sb.append((char)(node + 'A'));
        preOrder(left[node]);
        preOrder(right[node]);
    }

    private static void inOrder(int node) {
        if (node == -1) return;
        inOrder(left[node]);
        sb.append((char)(node + 'A'));
        inOrder(right[node]);
    }

    private static void postOrder(int node) {
        if (node == -1) return;
        postOrder(left[node]);
        postOrder(right[node]);
        sb.append((char)(node + 'A'));
    }
}
