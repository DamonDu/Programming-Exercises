class Solution {

	static int[] visited;
	static int[] pre;
	static int[] post;
	static int clock;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Interger>[] edge = new ArrayList[numCourses];
        int[] tag = new int[numCourses];
        ArrayList<Interger> start = new ArrayList<Interger>();

        visited = new int[numCourses];
        pre = new int[numCourses];
        post = new int[numCourses];
        clock = 0;

        for (int i = 0; i < prerequisites.length; i++) {
        	if (edge[prerequisites[i][0]] == null) {
        		edge[prerequisites[i][0]] = new ArrayList<Interger>();
        	}
        	edge[prerequisites[i][0]].add(prerequisites[i][1]);
        	tag[prerequisites[i][1]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
        	if (tag[i] == 0) {
        		start.add(i);
        	}
        }
        
        for (Interger st : start) {
        	 clock = 0;
        	 explore(st);
        }

        /*for (Interger st : start) {
        	 ArrayList<Interger> explore = new ArrayList();
        	 ArrayList<Interger> explored = new ArrayList();
        	 explore.add(st);
        	 while (!explore.isEmpty()) {
        	 	Interger temp = explore.get(explore.size() - 1);
        	 	explore.remove(explore.size() - 1);
        	 	explored.add()
        	 	if (edge[temp] != null) {
        	 		explore.addAll(edge[temp]);
        	 	}
        	 }
        }*/
    }

    public void explore(ArrayList[] edge, int vertex) {
    	visited[vertex] == 1;
    	previsit(vertex);
    	for (Interger i : edge[vertex]) {
    		if (visited[i] == 0) {
    			explore(edge, i);
    		}
    	}
    	postvisit(vertex);
    }

    public void previsit(int vertex) {
    	pre[vertex] = clock;
    	clock++;
    }

    public void postvisit(int vertex) {
    	post[vertex] = clock;
    	clock++;
    }
}