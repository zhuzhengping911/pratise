package com.zzp.pratise.myMap;

/**
 * Created by zhuzhengping
 * on 2017/8/28.
 */
public class MyMap<K,V> {

//    内部静态类，用于保存key，value值
    private static class Node<K,V>{
        K key = null;
        V value = null;
//        构造器
        Node(K key,V value){
            this.key = key;
            this.value = value;
        }

    }


//    通过一个数组来保存key，value键值对
    private Node[] nodes;

//    逻辑长度
    private int size;


//    放入元素，如果元素key已经存在，覆盖value，否则在数组中添加key，value的信息
    public void put(K key,V value){
        if(nodes == null){
//            如果数组为空，创建大小为10的数组
            nodes = new Node[10];
        }
        int index = indexOfKey(key); //查找key所在数组中的位置
        if(index != -1){
//            如果数组中找到对应的key值，覆盖node
            nodes[index].value = value;
        }else {
//            如果没有找到对应的key值，则在最后添加
            nodes[size] = new Node(key,value);
            size++;
        }

    }

//    查找该Key是否已经存在数组nodes中，如果找不到，返回-1，找到则返回数组中的下标
    private int indexOfKey(K Key){
        for (int index = 0 ; index < size; index++){
            if(Key.equals(this.nodes[index].key)){
                return index;
            }

        }
        return -1;
    }

//    根据Key获取Value值
    public V get(K key){

        int index = indexOfKey(key);
        if(index != -1){
            return (V) nodes[index].value;
        }
        return null;
    }

//    获取Map长度
    public int size(){
        return size;
    }

    public V get(int index){
        if(index >= nodes.length){
            return (V) "out of index!!!";
        }
        if(index != -1 ){
            if (nodes[index] == null){
                return (V) new NullPointerException();
            }
            return (V) nodes[index].value;
        }
        return null;
    }
}
