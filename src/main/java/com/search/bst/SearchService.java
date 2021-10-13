package com.search.bst;

import java.util.List;
import java.util.Map;

public interface SearchService {

    TreeNode constructBST(List<Integer> nums);

    Map.Entry<Integer, List<Integer>> nodesWithMaxDepth(TreeNode root);

}
