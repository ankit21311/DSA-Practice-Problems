

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long[] result = new long[n] ;
        Stack<Long> stack = new Stack<>() ;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            if(stack.isEmpty()){
                result[i] = -1L ;
            }
            else if(!stack.isEmpty() && arr[i] < stack.peek() ){
                result[i] = stack.peek() ;
            }
            else if(!stack.isEmpty() && arr[i] >= stack.peek()){
                while(!stack.isEmpty() && arr[i] >= stack.peek()) {
                    stack.pop() ;
                }
                if(!stack.isEmpty()){
                    result[i] = stack.peek() ;
                }else{
                    result[i] = -1L ;
                }
            }
            stack.push(arr[i]) ;
        }
       
        return result ;
        
    } 
}
