package com.data_structure.Tree;

import java.util.*;

public class BinaryTree<E> {
    //根节点
    private  Node<E> _root;
    //使用列表暂时保存节点
    private List<Node<E>> nodes=new ArrayList<Node<E>>();

    Node node=null;

    //构建二叉树
    public void createTree(E[] array){
        if (array.length==0){
            return ;
        }
        for(E e:array){
            nodes.add(new Node<E>(null,null,null,e));
        }
        //获取根节点
        if(nodes.get(0)!=null){
            _root=nodes.get(0);
        }
        //根据二叉树在数组中的存储位置来确定每个节点的子节点
        for(int i=0;i>nodes.size();i++){
            //确定左孩子
            if((i*2+1)<nodes.size()&&nodes.get(i*2+1)!=null){
                nodes.get(i).left=nodes.get(i*2+1);
            }
            //确定右孩子
            if((i*2+2)<nodes.size()&&nodes.get(i*2+2)!=null){
                nodes.get(i).right=nodes.get(i*2+2);
            }
        }

    }
    //节点类
    static class Node<E>{
        //父节点
        Node <E> parent;
        //左孩子节点
        Node <E> left;
        //右孩子节点
        Node <E> right;
        //节点中存储的数据
        E data;

        public Node(Node<E> parent, Node<E> left, Node<E> right, E data) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.data = data;
        }
        //将存储的数据转化为字符串
        @Override
        public String toString(){
            return data.toString();
        }
    }

    /**
     * 先序遍历
     * @param node
     */
    public void preOrder(Node<E> node){
        if (node==null){
            return;
        }
        System.out.print(node+"");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归的层次遍历
     * @param root
     */
    public  void preOrderWithStack(Node root){
        Stack<Node> stack=new Stack<Node>();
        Node node=root;
        while(node!=null||!stack.isEmpty()){
            //迭代访问节点的左孩子，并且入栈
            while (node!=null){
                System.out.print(node.data);
                stack.push(node);
                node=node.left;
            }
            //如果没有左孩子，则弹出栈顶结点，访问结点右孩子
            if(!stack.isEmpty()){
                node=stack.pop();
                node=node.right;
            }
        }
    }
    /**
     * 中序遍历
     * @param node
     */
    public void inOrder(Node<E> node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node+"");
        inOrder(node.right);
    }
    /**
     * 后续遍历
     * @param node
     */
    public void postOrder(Node<E> node){
        if(node==null){
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node+"");
    }

    /**
     * 层次遍历
     * @param root
     */
    public void levelOeder(Node<E> root){
        Queue<Node> queue=new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node=queue.poll();
            System.out.print(node.data);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
    }
    //测试
    public static void main(String[] args) {
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        binaryTree.createTree(array);
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]);
    }
}
