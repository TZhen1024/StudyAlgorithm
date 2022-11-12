package Daily;

public class Leetcode790 {
    public static void main(String[] args) {
        Leetcode790 leetcode790 = new Leetcode790();
        System.out.println(leetcode790.numTilings(1000));
    }

    // 感觉这题跟跳台阶差不多
    int MOD = (int)(1e9 + 7);
    /* 这种写法的用时比较长，感觉是因为有很多递归导致的调用消耗，尝试写下迭代写法
    int[] m = new int[1010];
    public int numTilings(int n) {
        m[1] = 1;
        m[2] = 2;
        return f(n, m);
    }
    public int f(int n, int[] m) {
        if (m[n] == 0) {
            m[n] += numTilings(n - 1);
            m[n] %= MOD;
            m[n] += numTilings(n - 2);
            m[n] %= MOD;
            for (int i = n - 1; i >=3 ; i--) {
                m[n] += (numTilings(n - i) * 2) % MOD;
                m[n] %= MOD;
            }
            m[n] += 2;
            m[n] %= MOD;
        }
        return m[n];
    }
    */
    public int numTilings(int n) {
        int[] m = new int[n + 10];
        m[1] = 1;
        m[2] = 2;
        m[3] = 5;
        int sum = m[1] + m[2] + m[3];
        for (int i = 4; i <= n; i++) {
            sum += m[i - 3];
            sum %= MOD;
            m[i] = (sum + 2) % MOD;
            sum += m[i];
            sum %= MOD;
        }
        return m[n];
    }
}
