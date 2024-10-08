## Leecode754题解

每次向左向右移动其实就是加减数字的变化，向左走就是减去，向右走就是加上。那么移动就变成了选择$\pm1\pm2\pm3\pm4...$这样一串数字的符号，移动到$target$就是这串数字的和等于$target$. 

在题目中，$target$正负都有，但是根据对称性，$target$和$-target$的最少次数是一样的。只需要考虑$target$为正的情况就可以。

$target$的范围到$10^9$, 结合这题的特征，很有可能是道数学题，分析如下：

1. 首先考虑最简单的情况，即$target = \frac{n(n + 1)}{2} = 1 + 2 + ... + n$, 那么显然这种情况下最小的移动次数就是$n$.

2. （1）中是数字符号全为正号的情况，当我们变化正负号，可以发现$\pm1\pm2...\pm n$可以取到$[-\frac{n(n+1)}{2}, \frac{n(n+1)}{2}$]之间的所有与$\frac{n(n+1)}{2}$奇偶性相同的数（因为每次变化符号，相差的值最小为2）。

   因此，如果$target$满足$\frac{n(n-1)}{2} < target < \frac{n(n+1)}{2}$, 且奇偶性与$\frac{n(n+1)}{2}$一致，那么$target$可以由$n$次移动得到。那是否是最小移动次数呢？假如说少走一步，那么即使一直向右走，也只能到达$\frac{n(n-1)}{2}$, 不可能到达$target$. 所以$n$就是最小移动次数。

   还有一种情况，就是$target$与$\frac{n(n + 1)}{2}$的奇偶性不一致。那么就从$n$开始向右，一步步找，直到找到一个$k$, 使得$target$与$\frac{k(k+1)}{2}$的奇偶性一致，那么$k$就是最小移动次数。因为只要奇偶性不一致，那么其通过变化正负符号能取到的所有取值都不可能包含$target$. 

**总之，就是通过n的变化扩大了数的可取范围，根据**$\frac{n(n+1)}{2}$**的奇偶性限制了可取到的数的奇偶性。所以最后就是找大于target最近的同奇偶性的n(n+1)/2类型的数**。



