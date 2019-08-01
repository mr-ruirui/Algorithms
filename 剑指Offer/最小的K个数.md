# 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。 链接在[这里](https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)。

非最优解法。
```
class Solution {
public:
    vector<int> GetLeastNumbers_Solution(vector<int> input, int k) {
        vector<int> result;
        if(input.size()<=4 ) return input;
        if(input.size()<k) return result;
        sort(input.begin(),input.end());
        for(int i=0;i<k;i++){
            result.push_back(input[i]);
        }
        return result;
    }
};
```