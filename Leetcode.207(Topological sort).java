/*
题目地址: https://leetcode.com/problems/course-schedule/description/

解题思路：
	问题抽象化：判断一组事件两两之间依赖关系是否成立
	问题转化：判断一个有向图是否为有向无还图(DAG)
	问题解决：拓扑排序(Topological Sorting)
	算法概述：
		1. 维护一个入度为0的节点的集合
		2. 选择一个入度为0的节点，删除之
		3. 更新0入度节点集合，循环步骤2、3
		4. 若最终图为空，则为DAG；反之则非。
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	
        int[] indegree = new int[numCourses];//所有节点的入度
        
        //构造一个邻接表来存储图
        ArrayList<Integer>[] edge = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
        	indegree[prerequisites[i][1]]++;
        	if (edge[prerequisites[i][0]] == null) {
        		edge[prerequisites[i][0]] = new ArrayList<Integer>();
        	}
        	edge[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        //维护一个入度为0的节点的集合
        Queue<Integer> start = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
        	if (indegree[i] == 0) {
        		start.offer(i);
        	}
        }

        //循环选择一个入度为0的节点，删除之，更新0入度节点集合
        while (!start.isEmpty()) {
        	int temp = start.poll();
        	indegree[temp]--;
        	if (edge[temp] != null) {
        		for (Integer i : edge[temp]) {
	        		indegree[i]--;
	        		if (indegree[i] == 0) {
	        			start.offer(i);
	        		}
        		}
        	}
        }

        //若最终图为空，则为DAG；反之则非
        for (int i = 0; i < numCourses; i++) {
        	if (indegree[i] >= 0) {
        		return false;
        	}
        }
        return true;
    }
}