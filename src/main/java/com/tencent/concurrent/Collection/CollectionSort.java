package com.tencent.concurrent.Collection;

import java.util.*;

/**
 * Collections.sort --依赖--> List.sort --> 依赖--> Arrays.sort
 * sort支持自定义排序器：Comparator，compare方法，升序排序返回，x1>x2返回1，x1<x2返回-1，x1=x2返回0，如果降序的话，相反即可.
 * 如果没有传递的话，用对象的compareTo方法排序，如果对象没有实现Comparable接口，会抛出异常.
 *
 * 多属性排序，可以用自定义排序器中，写明比较逻辑即可.
 * 需要避免整数溢出问题，比如a-b，如果a和b都是Integer.MIN_VALUE，那么a-b会溢出，导致结果不正确.
 */
public class CollectionSort {
    public static void main(String[] args) {
        listSortTest();
    }

    private static void listSortTest() {
        List<Integer> list = Arrays.asList(1,3,2,4);

        System.out.println("list sort before:" + list);
        list.sort(null);
        System.out.println("list sort after:" + list);

        list.sort(Comparator.reverseOrder());
        System.out.println("list sort desc after:" + list);

        Collections.sort(list);
        System.out.println("collection sort asc after:" + list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("collection sort desc after:" + list);

        Filter filter1 = new Filter(Integer.MIN_VALUE,1);
        Filter filter2 = new Filter(1,1);
        Filter filter3 = new Filter(-1,2);
        Filter filter4 = new Filter(4,3);
        Filter filter5 = new Filter(4,4);
        List<Filter> filters = new ArrayList();
        filters.add(filter1);
        filters.add(filter2);
        filters.add(filter3);
        filters.add(filter4);
        filters.add(filter5);

        //用对象的compareTo方法排序
        filters.sort(null);
        System.out.println("filter Comparable sort:" + filters);

        //根据order字段降序排序
        Comparator comparator = Comparator.comparing(Filter::getOrder);
        filters.sort(comparator.reversed());
        System.out.println("filter Comparator desc(order):" + filters);

        //根据order和order2字段降序排序
        Comparator comparator2 = new Comparator<Filter>() {
            @Override
            public int compare(Filter o1, Filter o2) {
                if(o1.getOrder() > o2.getOrder()) {
                    return -1;
                } else if(o1.getOrder() < o2.getOrder()) {
                    return 1;
                } else {
                    if(o1.getOrder2() > o2.getOrder2()) {
                        return -1;
                    } else if(o1.getOrder2() < o2.getOrder2()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        };

        filters.sort(comparator2);
        System.out.println("filter Comparator desc(order and order2)" + filters);
    }

    private static String toStr(Integer[] data) {
        String result = "";
        for (int i = 0; i < data.length; i++) {
            result = result + " " + data[i];
        }
        return result;
    }

    static class Filter implements Comparable<Filter> {
        int order = Integer.MAX_VALUE;

        int order2 = Integer.MAX_VALUE;

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public Filter(int order, int order2) {
            this.order = order;
            this.order2 = order2;
        }

        public int getOrder2() {
            return order2;
        }

        public void setOrder2(int order2) {
            this.order2 = order2;
        }

        @Override
        public String toString() {
            return "Filter{" +
                    "order=" + order +
                    ", order2=" + order2 +
                    '}';
        }

        @Override
        public int compareTo(Filter o) {
            if(this.getOrder() > o.getOrder()) {
                return -1;
            } else if(this.getOrder() < o.getOrder()) {
                return 1;
            } else {
                if(this.getOrder2() > o.getOrder2()) {
                    return -1;
                } else if(this.getOrder2() < o.getOrder2()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
