class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){

                if(s.charAt(i)==s.charAt(j) &&
                   (i-j<=2 || dp[j+1][i-1])){

                    dp[j][i]=true;
                }
            }
        }

        helper(ans,s,new ArrayList<>(),dp,0);

        return ans;
    }

    void helper(List<List<String>> ans,
                String s,
                List<String> curr,
                boolean[][] dp,
                int pos){

        if(pos==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=pos;i<s.length();i++){

            if(dp[pos][i]){

                curr.add(s.substring(pos,i+1));

                helper(ans,s,curr,dp,i+1);

                curr.remove(curr.size()-1);
            }
        }
    }
}