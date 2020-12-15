package AlgorithmsAndProblems;

import java.util.*;

public class maxSumPath {
    public static int maxPathSum(int ar1[], int ar2[])
    {
        int l1 = ar1.length;
        int l2 = ar2.length;

        int[] sumA = new int[l1];
        int[] sumB = new int[l2];

        sumA[l1-1] = ar1[l1-1];
        sumB[l2-1] = ar2[l2-1];
        for(int i = l1-2 ; i >=0 ; i--)
        {
            sumA[i]+=ar1[i]+sumA[i+1];
        }
        System.out.println();
        for(int i = l2-2 ; i >= 0 ; i--)
        {
            sumB[i]+=ar2[i]+sumB[i+1];
        }
        System.out.println();

        int l3 = l1 > l2?l2:l1;
        int maxSum = Integer.MIN_VALUE;
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0 ; i < l3-1; i++)
        {

            sum1+=ar1[i];
            sum2+=ar2[i];
            int temp = 0;
            if(ar1[i] == ar2[i])
            {
                 temp = 0;
                if(sum1+sumB[i+1] > sum2 +sumA[i+1])
                {
                    temp = sum1+sumB[i+1];

                }
                else
                {
                    temp = sum2 +sumA[i+1];
                }
                if(temp > maxSum)
                {
                    maxSum = temp;
                    System.out.println("Equal temp : " + temp);

                }
            }
            else
            {
                 temp = 0;
                if(sum1+ sumA[i+1] > sum2+ sumB[i+1])
                {
                    temp = sum1 + sumA[i+1];
                }
                else
                {
                    temp = sum2 + sumB[i+1];
                }
                if(temp > maxSum)
                {
                    maxSum = temp;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args)
    {
        Scanner k = new Scanner(System.in);
        int l1 = k.nextInt();
        int l2 = k.nextInt();
        int[] arr1 = new int[l1];
        int[] arr2 = new int[l2];
        for(int i = 0 ; i < l1; i++)
        {
            arr1[i] = k.nextInt();
        }

        for(int i = 0; i < l2; i++)
        {
            arr2[i] = k.nextInt();
        }

        System.out.println("maxPath : " + maxPathSum(arr1,arr2));

    }
}
