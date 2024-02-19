class Solution {
    static int matrixMultiplication(int N, int arr[]) {
        // code here
        int i = 1;
        int j = N - 1;
        int[][] dp = new int[N + 1][N + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int ans = solve(arr, i, j, dp);
        return ans;
    }

    static int solve(int[] arr, int n, int m, int[][] dp) {
        if (n >= m)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];

        int mn = Integer.MAX_VALUE;
        for (int k = n; k < m; k++) {
            int temp = solve(arr, n, k, dp) + solve(arr, k + 1, m, dp) + arr[n - 1] * arr[k] * arr[m];
            if (temp < mn)
                mn = temp;
        }
        dp[n][m] = mn;
        return dp[n][m];
    }
}
