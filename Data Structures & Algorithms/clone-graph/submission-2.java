/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return _dfs(node, new HashMap<>());
    }

    private Node _dfs(Node node, Map<Node, Node> oldToNew) {
        // Base condition
        if (node == null) {
            return null;
        }

        // Main condition
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        List<Node> neighbours = node.neighbors;
        for (Node neighbor : neighbours) {
            copy.neighbors.add(_dfs(neighbor, oldToNew));
        }
        return copy;
    }
}