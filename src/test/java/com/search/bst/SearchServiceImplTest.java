package com.search.bst;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SearchServiceImplTest {

    SearchService searchService;
    @Before
    public void setUp() throws Exception {
        searchService = new SearchServiceImpl();
    }


    @Test
    public void withPositiveValues() {
        TreeNode root = searchService.constructBST(List.of(12, 11, 90, 82, 7,9));

        /*
        sorted order =  7, 9, 11, 12, 82, 90

                  11
                /    \
              7       82
               \      / \
                9    12  90


         */
        assert  searchService.nodesWithMaxDepth(root) != null;
        Map.Entry<Integer, List<Integer>> res = searchService.nodesWithMaxDepth(root);

        assert res.getKey().equals(3);
        assert res.getValue().equals(Arrays.asList(9, 12, 90));
    }

    @Test
    public void withNegativeValues() {
        TreeNode root = searchService.constructBST(List.of(12, -11, 90, -5, 7,9, 100, 6, 88));

        /*
        sorted order =  -11,-5,6,7,9,12,88,90,100

                  9
                /    \
              -5       88
              / \      / \
            -11  6    12  90
                  \       /
                   7     100
         */

        assert  searchService.nodesWithMaxDepth(root) != null;
        Map.Entry<Integer, List<Integer>> res = searchService.nodesWithMaxDepth(root);
        assert res.getKey().equals(4);
        assert res.getValue().equals(Arrays.asList(7, 100));
    }
}