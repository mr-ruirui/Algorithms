# 题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。链接在[这里](https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)。

递增排序和乘积最小，就相到双指针，利用双指针前后移动寻找即可。

P.S. 注意一个细节，下面那段代码的边界条件是head!tail，但是后面条件判断如果是连续的（全部是if不是else if），因此可能出现连续判断导致head++然后tail--然后数组越界，需要改为else if。
```
class Solution {
public:
    vector<int> FindNumbersWithSum(vector<int> array,int sum) {
        vector<int> result; 
        if(array.size()==0) return result;
        int head=0;
        int tail=array.size()-1;
        while(head<tail){
            if(array[head]+array[tail]==sum){
                result.push_back(array[head]);
                result.push_back(array[tail]);
                break;
            }
            if(array[head]+array[tail]>sum) tail--;
            if(array[head]+array[tail]<sum) head++;
        }
        return result;
    }
};


vector<int> FindNumbersWithSum(vector<int> array,int sum) {
    vector<int> result;
    if(array.size()==0) return result;
    int head=0;
    int tail=array.size()-1;
    while(head!=tail) {
        if(array[head]+array[tail]==sum) {
            result.push_back(array[head]);
            result.push_back(array[tail]);
            break;
        }
        else if(array[head]+array[tail]>sum)    // 注意else if
            tail--;
        else if(array[head]+array[tail]<sum)
            head++;
    }
    return result;
}
```