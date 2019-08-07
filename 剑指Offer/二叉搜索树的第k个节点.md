# 题目描述
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。 链接在[这里](https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)。

观察发现中序遍历路径即为从小到大的排列，第k个即为结果。
```
/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};
*/
class Solution {
public:
    TreeNode* arr[1000];
    int cnt=0;
    void inOrder(TreeNode* pRoot){
        if(pRoot->left!=NULL) inOrder(pRoot->left);
        arr[cnt++]=pRoot;
        if(pRoot->right!=NULL) inOrder(pRoot->right);
    }
    TreeNode* KthNode(TreeNode* pRoot, int k)
    {
        if(k<1 || pRoot==NULL) return NULL;
        inOrder(pRoot);
        if(k>cnt) return NULL;
        return arr[k-1];
    }

    
};
```