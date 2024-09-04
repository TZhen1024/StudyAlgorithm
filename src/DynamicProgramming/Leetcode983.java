package DynamicProgramming;

import java.util.Arrays;

public class Leetcode983 {
    public static void main(String[] args) {
        int[] days = new int[] {1,4,6,9,10,11,12};
        int[] costs = new int[] {3, 13, 45};
        System.out.println(new Leetcode983().mincostTickets(days, costs));
    }

    int[] res;
    public int mincostTickets(int[] days, int[] costs) {
        // 首先写记忆化搜索的方法
        res = new int[days.length];
        int max = 365001;
        Arrays.fill(res, max);
        return solve(days, costs, 0, 0);
    }
    // 解决从i开始的天数，这里跟动态规划类似，分解出来的状态都是一个范围
    // 针对某天做了一个选择之后，剩下的问题怎么解决
    public int solve(int[] days, int[] costs, int coverDay, int i) {
        // 首先考虑days[0]
        int min = 365001;
        if (i >= days.length) { // i超出范围了，退出
            return 0;
        }

//        if (res[i] != min) {
//            return res[i];
//        }

        if (coverDay >= days[i]) { // days[i]已经有票了
            min = Math.min(min, solve(days, costs, coverDay, i + 1));
            return min;
        }

        if (res[i] != min) {
            return res[i];
        }

        // 主体函数可以先写出来，再去考虑记忆搜索优化
        min = Math.min(min, costs[0] + solve(days, costs, days[i], i + 1)); // 从i + 1开始的天的最低消费
        min = Math.min(min, costs[1] + solve(days, costs, days[i] + 6, i + 1));
        min = Math.min(min, costs[2] + solve(days, costs, days[i] + 29, i + 1));

        res[i] = min; // 注意res[i]也表示从i往后所有天加在一起的最低消费
        return res[i];
    }
}
