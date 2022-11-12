package Daily;

public class Leetcode790 {
    public static void main(String[] args) {
        Leetcode790 leetcode790 = new Leetcode790();
        System.out.println(leetcode790.numTilings(5));
    }

    // 感觉这题跟跳台阶差不多
    int MOD = (int)(1e9 + 7);
    int[] m = new int[1010];
    public int numTilings(int n) {
        m[1] = 1;
        m[2] = 2;
        return f(n, m);
    }
    public int f(int n, int[] m) {
        if (m[n] == 0) {
            for (int i = n - 1; i >=3 ; i--) {
                m[n] += (numTilings(n - i) * 2) % MOD;
                m[n] %= MOD;
            }
            m[n] += numTilings(n - 2);
            m[n] %= MOD;
            m[n] += numTilings(n - 1);
            m[n] %= MOD;
            m[n] += 2;
            m[n] %= MOD;
        }
        return m[n];
    }
}
