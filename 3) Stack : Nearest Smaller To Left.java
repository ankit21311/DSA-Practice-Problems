//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        ArrayList<Integer> result = new ArrayList<>() ;
        Stack<Integer> stack = new Stack<>() ;
        for(int i = 0 ; i<n ;i++){
            if(stack.isEmpty()){
               result.add(-1)  ;
            }
            else if(!stack.isEmpty() && a[i] > stack.peek()){
                result.add(stack.peek())  ;
            }
            else if(!stack.isEmpty() && a[i] <= stack.peek()){
                while(!stack.isEmpty() && a[i] <= stack.peek()){
                    stack.pop() ;
                }
                if(stack.isEmpty()){
                     result.add(-1) ;
                }else{
                     result.add(stack.peek()) ;
                }
            }
            stack.push(a[i]) ;
        }
        return result ;
        
    }
}
