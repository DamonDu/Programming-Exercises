class Solution {
	int tag = 0;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        ArrayList<Integer> leaf = new ArrayList<Integer>();
        int minHeight[] = new int[n];
        int[] num = new int[n];
        //ArrayList<Integer> explore = new ArrayList<Integer>();

        for (int i = 0; i < edges.length; i++) {
        	num[edges[i][0]]++;
        	num[edges[i][1]]++;

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
    		if (num[i] == 1) {
    			leaf.add(i);
    		}
    	}

    	int[] height = new int[n];

    	for (Integer l: leaf) {
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		temp.add(l);
    		height = explore(temp, graph, height);
    		tag = 0;
    	}

    	int min = Integer.MAX_VALUE;
    	ArrayList<Integer> minIndex = new ArrayList<>();

    	for (int i = 0; i < n; i++) {
    		if (height[i] < min) {
    			min = height[i];
    			minIndex.clear();
    			minIndex.add(i);
    		}
    		else if (height[i] == min) {
    			minIndex.add(i);
    		}
    	}

    	return minIndex;
    }

    private int[] explore(ArrayList<Integer> explored, ArrayList<Integer>[] graph, int[] height) {
    	tag++;
    	ArrayList<Integer> next = new ArrayList<Integer>();
    	for (Integer e : explored) {
    		if (height[e] < tag) {
    			height[e] = tag;
    		}
    	}
    	for (Integer e : explored) {
    		for (Integer node : graph[e]) {
    			if (visited[node] == 0) {
    				next.add(node);
    			}
    		}
    	}
    	explore(next, graph, height);
    	return height;
    }
}