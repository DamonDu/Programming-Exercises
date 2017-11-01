/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {

    private Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	return clone(node);
    }

    //迭代实现深度优先
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
    	if (node == null) {
    		return null;
    	}

    	if (map.containsKey(node.label)) {
        	return map.get(node.label);
        }

    	UndirectedGraphNode temp = new UndirectedGraphNode(node.label);
    	map.put(temp.label, temp);

        for (UndirectedGraphNode n : node.neighbors) {
        	temp.neighbors.add(clone(n));
        }
        return temp;
    } 
}