package com.data_structure.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 常见排序算法总结
 */
public class Sort {
    /**
     * 冒泡排序
     * @param arrar
     */
    public static void BubbleSort(int array[]){
        int temp;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }

    }

    /**
     * 冒泡排序升级版一，减少排序轮次。
     * @param array
     */
    public static void BubbleSort_01(int array[]){
        int temp;
        boolean isSorted=true;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                    //因为存在元素交换，则还没有排序完成，标记设置为flase
                    isSorted=false;
                }
            }
            if (isSorted)
                break;
        }
    }

    /**
     * 基于边界的优化版冒泡排序
     * @param array
     */
    public static void BubbleSort_02(int array[]){
        int temp;
        for(int i=0;i<array.length;i++){
            //有序标记，每一轮的初始值为true；
            boolean isSorted=true;
            //无序数列的边界，每次比较到次为止。
            int sortBorder=array.length-1;
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                    //因为存在元素交换，则还没有排序完成，标记设置为flase
                    isSorted=false;
                    //边界值更新为最后一次交换元素的位置
                    sortBorder=j;
                }
            }
            if (isSorted)
                break;
        }
    }
    /**
     *
     * @param args
     */
    public static void main(String [] args){
        //冒泡排序测试
        int array[]={2,4,6,1,78,23,-1,3,5};
        //BubbleSort(array);
        //BubbleSort_01(array);
        BubbleSort(array);
        System.out.println("冒泡排序："+ Arrays.toString(array));

    }
}
