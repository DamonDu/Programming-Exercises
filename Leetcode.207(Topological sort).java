class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	ArrayList<Interger>[] edge = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
        	indegree[prerequisites[i][1]]++;
        	if (edge[prerequisites[i][0]] == null) {
        		edge[prerequisites[i][0]] = new ArrayList<Interger>();
        	}
        	edge[prerequisites[i][0]].add(prerequisites[i][1]);
        }
    }
}