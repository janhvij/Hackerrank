import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    @Override
    public int getResult() {
        return sum;
    }

    @Override
    public void visitNode(TreeNode node) {
        // Do nothing for internal nodes
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final int MOD = 1000000007;
    private long product = 1;

    @Override
    public int getResult() {
        return (int) product;
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int sumNonLeafEvenDepth = 0;
    private int sumGreenLeaf = 0;

    @Override
    public int getResult() {
        return Math.abs(sumNonLeafEvenDepth - sumGreenLeaf);
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumNonLeafEvenDepth += node.getValue();
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumGreenLeaf += leaf.getValue();
        }
    }
}

public class Visitor {
  
    public static Tree solve() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    final int[] values = new int[n];
    for (int i = 0; i < n; i++) {
        values[i] = sc.nextInt();
    }

    final int[] colorsInt = new int[n];
    for (int i = 0; i < n; i++) {
        colorsInt[i] = sc.nextInt();
    }

    final Color[] colors = new Color[n];
    for (int i = 0; i < n; i++) {
        colors[i] = (colorsInt[i] == 0) ? Color.RED : Color.GREEN;
    }

    List<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }

    boolean[] visited = new boolean[n];

    return buildTree(0, 0, values, colors, adj, visited);
}

// Helper method (static) to build tree recursively
private static Tree buildTree(int node, int depth, int[] values, Color[] colors, List<Integer>[] adj, boolean[] visited) {
    visited[node] = true;
    List<Integer> children = new ArrayList<>();
    for (int nei : adj[node]) {
        if (!visited[nei]) {
            children.add(nei);
        }
    }

    if (children.isEmpty()) {
        return new TreeLeaf(values[node], colors[node], depth);
    } else {
        TreeNode treeNode = new TreeNode(values[node], colors[node], depth);
        for (int c : children) {
            treeNode.addChild(buildTree(c, depth + 1, values, colors, adj, visited));
        }
        return treeNode;
    }
}


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}