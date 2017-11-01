/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {

    static private Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
    	if (node == null) {
    		return null;
    	}
    	UndirectedGraphNode temp = new UndirectedGraphNode(node.label);
        map.put(temp.label, temp);
        for (UndirectedGraphNode n : node.neighbors) {
        	UndirectedGraphNode next;
        	if (n.label == node.label) {
        		temp.neighbors.add(temp);
        		continue;
        	}
        	if (map.containsKey(n.label)) {
	        	temp.neighbors.add(map.get(n.label));
	        }
	        else {
	        	next = clone(n);
	        	temp.neighbors.add(next);
	        	map.put(temp.label, temp);
	        }
        }
        return temp;
    } 
}