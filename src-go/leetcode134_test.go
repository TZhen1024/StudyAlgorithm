package leetcode

import (
	"fmt"
	"testing"
)

func canCompleteCircuit(gas []int, cost []int) int {
	// 首先计算diff值
	// eg. gas = [1,2,3,4,5], cost=[3,4,5,1,2],diff=[-2,-2,-2,3,3]
	// 实际上就是从一个位置idx开始，只要值大于0，就不断聚合
	// 如果能聚合到idx的前一位，就说明idx是答案
	// 如果不能，也可以利用idx的聚合结果
	// 比如，如果diff=[3,-2,-2,3,-2]
	// 聚合变化为diff=[1,0,-2,3,-2]->[1,0,-2,1,0]->[0,0,-2,2,0]->[0,0,0,0,0]
	n := len(gas)
	diff := make([]int, n)
	for i := 0; i < n; i++ {
		diff[i] = gas[i] - cost[i]
	}
	if n == 1 && diff[0] >= 0 {
		return 0
	}
	idx := 0
	for idx < n {
		if diff[idx] <= 0 {
			idx++
			continue
		}
		i := 1
		for diff[idx]+diff[(idx+i)%n] >= 0 {
			diff[idx] = diff[idx] + diff[(idx+i)%n]
			diff[(idx+i)%n] = 0
			// 由于(idx + i) % n可能是最后一位，所以需要再次mod n
			nextIdx := ((idx+i)%n + 1) % n
			if nextIdx == idx {
				return idx
			}
			i++
		}
		idx++
	}
	return -1
}

func TestCanCompleteCircuit(t *testing.T) {
	gas := []int{1, 2, 3, 4, 5}
	cost := []int{3, 4, 5, 1, 2}
	fmt.Println(canCompleteCircuit(gas, cost))
}
