package leetcode;

public class 按平方数来分割整数_279 {
	
	public int numSquares(int n) {
		
		int[] dp = new int[n+1];
		dp[1]=1;
		for (int i = 1; i <= n; i++) {
			
			for(int j=1;j*j<=i;j++) {
				if(j*j<=n) {
					dp[i]=Math.min(dp[i], dp[i-j*j]+1);
				}
			}
		}
		
		return dp[n];
	}

}
