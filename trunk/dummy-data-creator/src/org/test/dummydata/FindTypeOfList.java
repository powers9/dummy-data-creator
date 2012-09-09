package org.test.dummydata;

import java.lang.reflect.Type;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
 
public class FindTypeOfList {
    java.util.List<SampleVO> fooList = new ArrayList<SampleVO>();
 
    public static void main(String[] args) throws Exception {
        Field field = FindTypeOfList.class.getDeclaredField("fooList");
 
        Type type = field.getGenericType();
        System.out.println("type: " + type);
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            System.out.println("actual type args:");
            for (Type t : pt.getActualTypeArguments()) {

                System.out.println(t.toString().replace("class ",""));
            }
        }
// 
//        System.out.println();
// 
//        Object obj = field.get(new FindTypeOfList());
//        System.out.println("obj: " + obj);
//        System.out.println("obj class: " + obj.getClass());
    }
 
    static class Foo {}
 
    static class Bar extends Foo {}
}