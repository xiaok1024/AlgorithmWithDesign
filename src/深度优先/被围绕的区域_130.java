package 深度优先;

public class 被围绕的区域_130 {
/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

		找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
		
		示例:
		
		X X X X
		X O O X
		X X O X
		X O X X
		运行你的函数后，矩阵变为：
		
		X X X X
		X X X X
		X X X X
		X O X X
		解释:
		
		被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 
		任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
		如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
	private int[][] direction= {{0,1},{0,-1},{1,0},{-1,0}};
	private int m,n;
	
	public void solve(char[][] board) {
		if(board.length==0 || board == null) return;
		m= board.length; //row
		n=board[0].length;//column
		//使用dfs进行边界搜索
		for (int i = 0; i < m; i++) {
			dfs(board,i,0);
			dfs(board,i,n-1);
		}
		//使用dfs进行边界搜索
		for (int j = 0; j < n; j++) {
			dfs(board,0,j);
			dfs(board,m-1,j);
		}
		
		//进行遍历二维数组
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
			
				  if (board[i][j] == 'T') board[i][j] = 'O';
		            else if (board[i][j] == 'O') board[i][j] = 'X';
			}
		}
		
	
	}

	private void dfs(char[][] board, int r, int c) {
		if(r<0 || r>=m || c<0 || c>=n || board[r][c] !='O') return;
		//设置为标记位,将边界为0的换成别的临时值
		board[r][c] ='T';
		for(int k=0;k<direction.length;k++) {
			//等于上下左右搜素
			dfs(board,r+direction[k][0],c+direction[k][1]);
		}
	}
	
	


}
