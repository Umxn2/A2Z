import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        int v = 4;
        int edges[][] = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 3, 0 }, { 0, 2 } };
        int m = 3;
        Solution solution = new Solution();

        System.out.println(solution.graphColoring(v, edges, m));
    }

    boolean graphColoring(int v, int[][] edges, int m) {
        Map<Integer, Integer> currColor = new HashMap<>();
        List<Integer> colors = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            colors.add(i);
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            assert edges[i].length == 2;
            int first = edges[i][0];
            int second = edges[i][1];
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        boolean[] visited = new boolean[v];
        boolean[] globalVisited = new boolean[v];
        AtomicInteger sum = new AtomicInteger(0);

        for (List<Integer> nodes : graph) {
            for (int node : nodes) {
                if (!globalVisited[node]) {
                    AtomicInteger num = new AtomicInteger(0);
                    visited[node] = true;
                    globalVisited[node] = true;
                    colorGraph(
                        graph,
                        visited,
                        currColor,
                        node,
                        colors,
                        num.get(),
                        v,
                        globalVisited,
                        num
                    );
                    sum.addAndGet(num.get());
                    visited[node] = false;
                }
            }
        }
        if (sum.get() >= v) return true;
        return false;
    }

    boolean colorGraph(
        List<List<Integer>> graph,
        boolean[] visited,
        Map<Integer, Integer> currColor,
        int node,
        List<Integer> colors,
        int nodesPainted,
        int maxNodes,
        boolean[] globalVisited,
        AtomicInteger max
    ) {
        List<Integer> neighbourColor = new ArrayList<>();
        for (Integer neighbours : graph.get(node)) {
            neighbourColor.add(currColor.get(neighbours));
        }
        List<Integer> possibleColors = colors
            .stream()
            .filter(num -> !neighbourColor.contains(num))
            .collect(Collectors.toList());
        if (
            possibleColors.size() == 0 &&
            neighbourColor.size() != graph.get(node).size()
        ) return false;
        if (max.get() < nodesPainted) {
            max.set(nodesPainted);
        }
        if (nodesPainted == maxNodes) return true;
        for (Integer possibleColor : possibleColors) {
            currColor.put(node, possibleColor);
            for (Integer neighbours : graph.get(node)) {
                if (!visited[neighbours]) {
                    visited[neighbours] = true;
                    globalVisited[neighbours] = true;
                    if (
                        colorGraph(
                            graph,
                            visited,
                            currColor,
                            neighbours,
                            colors,
                            nodesPainted + 1,
                            maxNodes,
                            globalVisited,
                            max
                        )
                    ) return true;
                    visited[neighbours] = false;
                }
            }
            currColor.remove(node);
        }
        return false;
    }
}
