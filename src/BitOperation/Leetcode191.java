package BitOperation;

public class Leetcode191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
    }
    public static int hammingWeight(int n) {
        int x = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((((x & n) >> i) & 1) == 1) // 这里“ & 1”的原因是, 负数（java里面负数的最高位为1）右移补的是1，负数右移31位得到的结果是-1.
                //https://blog.csdn.net/qq_39314099/article/details/110434039#:~:text=System.out.println%20%28%22%E8%B4%9FintValue%E6%97%A0%E7%AC%A6%E5%8F%B7%E5%8F%B3%E7%A7%BB31%E4%BD%8D%EF%BC%9A%22%20%2B%20%28-intValue%20%3E%3E%3E,31%29%29%3B%20%2F%2F%20%E8%BE%93%E5%87%BA%20%3D%3D%3E%20%E8%B4%9FintValue%E6%97%A0%E7%AC%A6%E5%8F%B7%E5%8F%B3%E7%A7%BB31%E4%BD%8D%EF%BC%9A1%20%E6%89%80%E4%BB%A5%E6%97%A0%E7%AC%A6%E5%8F%B7%E5%8F%B3%E7%A7%BB%E4%B9%9F%E5%8F%AF%E4%BB%A5%E5%88%A4%E6%96%AD%E5%87%BA%E4%B8%80%E4%B8%AA%E6%95%B0%E7%9A%84%E6%AD%A3%E8%B4%9F%EF%BC%8C%E5%A6%82%E6%9E%9C%E6%98%AF%E9%9D%9E%E8%B4%9F%E6%95%B0%EF%BC%8C%E9%82%A3%E4%B9%88%E6%97%A0%E7%AC%A6%E5%8F%B7%E5%8F%B3%E7%A7%BB31%E4%BD%8D%E7%AD%89%E4%BA%8E0%EF%BC%8C%E5%A6%82%E6%9E%9C%E6%98%AF%E8%B4%9F%E6%95%B0%EF%BC%8C%E6%97%A0%E7%AC%A6%E5%8F%B7%E5%8F%B3%E7%A7%BB31%E4%BD%8D%E7%AD%89%E4%BA%8E1%E3%80%82
                res++;
            x = x << 1;
        }
        return res;
    }
}
