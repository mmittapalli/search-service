package com.search.bst;

import java.util.*;

public class SearchServiceImpl implements SearchService {

    private Map<Integer, List<Integer>> nodesByLevel;

    @Override
    public TreeNode constructBST(List<Integer> numbers) {

        Integer[] numberArray = numbers.toArray(Integer[]::new);
        Arrays.sort(numberArray);
        return helper(numberArray,0, numberArray.length-1);
    }


    @Override
    public Map.Entry<Integer, List<Integer>> nodesWithMaxDepth(TreeNode root) {
        if(root == null) return null;

        buildNodesByLevelMap(root);

        return nodesByLevel.entrySet().stream().max(Map.Entry.comparingByKey()).get();
    }

    private void buildNodesByLevelMap(TreeNode root) {
        nodesByLevel = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        while(!que.isEmpty()){
            nodesByLevel.put(level, new ArrayList<>());
            int size = que.size();
            for(int i=0;i<size; i++){
                TreeNode node = que.poll();
                nodesByLevel.get(level).add(node.val);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            level++;
        }
    }


    private TreeNode helper(Integer[] sortedNumbers, int left, int right){

        if(left > right) return null;
        int p = left + (right-left)/2;
        TreeNode root = new TreeNode(sortedNumbers[p]);

        root.left = helper(sortedNumbers, left, p-1);
        root.right = helper(sortedNumbers, p+1, right);

        return root;
    }
}
