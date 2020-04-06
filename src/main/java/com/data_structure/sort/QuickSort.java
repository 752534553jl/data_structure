package com.data_structure.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 采用递归实现快速排序
 */
class QuickSort_01{
    public  void quickSort(int[] arr ,int startIndex,int endIndex){
        //递归结束标志
        if(startIndex>=endIndex)
            return;
        //获得基准元素下标
        int pivotIndex=partition(arr,startIndex,endIndex);
        //分为2堆，递归调用
        quickSort(arr,startIndex,pivotIndex-1);
        quickSort(arr,pivotIndex+1,endIndex);
    }

    /**
     * 单边循环法，获取一轮排序结束后基准元素的下标
     * @param arr   数组
     * @param startIndex   起始位置
     * @param endIndex     结束位置
     * @return
     */
    public  int partition(int [] arr ,int startIndex,int endIndex){
        //默认设置第一个元素为排序开始的基准元素
        int pivot =arr[startIndex];
        int mark=startIndex;
        for(int i=startIndex+1;i<=endIndex;i++){
            if(arr[i]<pivot){
                mark++;
                int p=arr[mark];
                arr[mark]=arr[i];
                arr[i]=p;
            }
        }
        arr[startIndex]=arr[mark];
        arr[mark]=pivot;
        return mark;

    }
}
/**
*快速排序的非递归实现
 */
class QuickSort_02{
    public void QuickSort(int[] arr,int startIndex,int endIndex){
        //使用一个集合栈来代替递归的函数栈
        Stack<Map<String,Integer>> quickSortStack =new Stack<Map<String, Integer>>();
        //整个数列的起止下标，以哈希的方式入栈
        Map rootParam=new HashMap();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        quickSortStack.push(rootParam);
        //循环条件结束，栈为空
        while (!quickSortStack.isEmpty()){
            //栈顶元素出栈，得到起止下标
            Map<String,Integer> param=quickSortStack.pop();
            //得到基准元素的位置
            int pivotIndex =partition(arr,param.get("startIndex"),param.get("endIndex"));
            //根据基准元素，将数列分为2部分，并且把每一部分的气质下标分别入栈
            if(param.get("startIndex")<pivotIndex-1){
                Map<String,Integer> leftParam=new HashMap<String, Integer>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if(param.get("endIndex")>pivotIndex+1){
                Map<String,Integer> rightParam=new HashMap<String, Integer>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }

    }
    /**
     * 单边循环法，获取一轮排序结束后基准元素的下标
     * @param arr   数组
     * @param startIndex   起始位置
     * @param endIndex     结束位置
     * @return
     */
    public  int partition(int [] arr ,int startIndex,int endIndex){
        //默认设置第一个元素为排序开始的基准元素
        int pivot =arr[startIndex];
        int mark=startIndex;
        for(int i=startIndex+1;i<=endIndex;i++){
            if(arr[i]<pivot){
                mark++;
                int p=arr[mark];
                arr[mark]=arr[i];
                arr[i]=p;
            }
        }
        arr[startIndex]=arr[mark];
        arr[mark]=pivot;
        return mark;

    }
}
/**
 * 快速排序相关算法测试
 */
public class QuickSort {
    public static void main(String[] args){
        int arr[]={4,7,3,5,6,2,8,1};
        QuickSort_01 quickSort01=new QuickSort_01();
        quickSort01.quickSort(arr,0,7);
        System.out.print("递归实现快速排序："+ Arrays.toString(arr));
        System.out.println();
        int arr1[]={4,7,3,5,6,2,8,1};
        QuickSort_02 quickSort02=new QuickSort_02();
        quickSort02.QuickSort(arr1,0,7);
        System.out.print("非递归实现快速排序："+ Arrays.toString(arr1));


    }

}
