//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maxton.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListUtils {
    public ListUtils() {
    }

    public static boolean isNullOrEmpty(Collection list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotNullOrEmpty(Collection list) {
        return !isNullOrEmpty(list);
    }

    public static String toString(Object... objs) {
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < objs.length; ++i) {
            if (i != 0) {
                buffer.append(",");
            }

            buffer.append(objs[i]);
        }

        return buffer.toString();
    }

    public static Integer[] stringArr2intArr(String[] arr) {
        Integer[] i = new Integer[arr.length];
        int index = 0;
        String[] var3 = arr;
        int var4 = arr.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String str = var3[var5];
            if (StringUtils.isInt(str)) {
                i[index++] = Integer.parseInt(str);
            }
        }

        return i;
    }

    public static <T> List<T> merge(List<T> target, List... lists) {
        for(int i = 0; i < lists.length; ++i) {
            target.addAll(lists[i]);
        }

        return target;
    }

    public static <T> String list2String(List<T> list) {
        StringBuffer buffer = new StringBuffer();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            T t = (T) var2.next();
            buffer.append(t.toString());
        }

        return buffer.toString();
    }

    public static String join(List<? extends Object> objs, String seperator) {
        if (isNullOrEmpty(objs)) {
            return null;
        } else {
            StringBuffer buffer = new StringBuffer();

            for(int i = 0; i < objs.size(); ++i) {
                if (i != 0) {
                    buffer.append(seperator);
                }

                buffer.append(objs.get(i).toString());
            }

            return buffer.toString();
        }
    }

    public static String join(Object[] objs, String seperator) {
        if (objs != null && objs.length != 0) {
            StringBuffer buffer = new StringBuffer();

            for(int i = 0; i < objs.length; ++i) {
                if (objs[i] != null) {
                    if (i != 0) {
                        buffer.append(seperator);
                    }

                    buffer.append(objs[i].toString());
                }
            }

            return buffer.toString();
        } else {
            return null;
        }
    }

    public static String[] toArray(Collection<String> array) {
        return isNullOrEmpty(array) ? null : (String[])array.stream().toArray((x$0) -> {
            return new String[x$0];
        });
    }
}
