class Solution {
	int tag = 0;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        ArrayList<Integer> leaf = new ArrayList<Integer>();
        ArrayList<Integer> temp;
        int minHeight[] = new int[n];
        int[] edgeNum = new int[n];
        int[] deleted = new int[n];
        int num = n;
        //ArrayList<Integer> explore = new ArrayList<Integer>();

        for (int i = 0; i < edges.length; i++) {
        	edgeNum[edges[i][0]]++;
        	edgeNum[edges[i][1]]++;

        	if (graph[edges[i][0]] == null) {
        		graph[edges[i][0]] = new ArrayList<Integer>();
        	}
        	graph[edges[i][0]].add(edges[i][1]);
        	if (graph[edges[i][1]] == null) {
        		graph[edges[i][1]] = new ArrayList<Integer>();
        	}
        	graph[edges[i][1]].add(edges[i][0]);
        }

    	for (int i = 0; i < n; i++) {
    		if (edgeNum[i] == 1) {
    			deleted[i] = 1;
                for (Integer e : graph[i]) {
                    edgeNum[e]--;
                    if (!leaf.contains(e))
                        leaf.add(e);
                }
                num--;
    		}
    	}

        while (num > 2) {
            for (Integer i : leaf) {
                if (edgeNum[i] != 1) {
                    leaf.remove(i);
                }
            }
            temp = new ArrayList<Integer>();
            for (Integer i : leaf) {
                deleted[i] = 1;
                for (Integer e : graph[i]) {
                    edgeNum[e]--;
                    if (!temp.contains(e))
                        temp.add(e);
                }
                num--;
            }
            leaf = temp;
            temp = null;
        }

        return leaf;
    }
}