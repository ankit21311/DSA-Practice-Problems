//1
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l==r){
            return ;
        }
        int mid = l+(r-l)/2 ;
        mergeSort(arr,l,mid) ;
        mergeSort(arr,mid+1,r) ;
        merge(arr,l,mid,r) ;
        
        // return arr ;

    }
    public static void merge(int[] arr , int low , int mid , int high){
        
        int left = low ;
        int right = mid+1 ;
        ArrayList<Integer> temp = new ArrayList<>() ;
        while(left <= mid && right<=high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]) ;
                left++ ;
            }
            else{
                temp.add(arr[right]) ;
                right++ ;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++ ;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++ ;
        }
        int k = low ;
        for(int num : temp){
            arr[k++] = num ;
        }
        
    }
}


//2
class Solution 
{ 
    int[] sortArr(int[] arr, int n) 
    { 
        // code here
        if(n == 1){
            return arr ;
        }
        MergeSort(arr , 0 , n-1) ;
        return arr ;
    }
    int[] MergeSort(int[] arr , int left , int right){
        if(left<right){
            int mid = (left+right)/2 ;
            MergeSort(arr , left , mid) ;
            MergeSort(arr,mid+1 , right) ;
            Merge(arr , left ,mid,right) ;
        }
        return arr ;
    }
    void Merge(int[] arr , int left , int mid , int right){
        int n1 = mid - left + 1;
        int n2 = right - mid ;
        int[] arr1 = new int[n1] ;
        int[] arr2 = new int[n2] ;
        for(int i = 0 ; i<n1 ; i++){
            arr1[i] = arr[i+left] ;
        }
        for(int j = 0 ; j<n2 ; j++){
            arr2[j] = arr[mid+j+1] ;
        }
        int i = 0 , j = 0 , k = left ;
        while(i<n1 && j<n2){
            if(arr1[i] <= arr2[j]){
                arr[k] = arr1[i] ;
                i++ ;
            }
            else{
                arr[k] = arr2[j] ;
                j++ ;
            }
            k++ ;
        }
        while(i<n1){
            arr[k] = arr1[i] ;
            i++ ;
            k++ ;
        }
        while(j<n2){
            arr[k] = arr2[j] ;
            j++ ;
            k++ ;
        }
    }
} 
