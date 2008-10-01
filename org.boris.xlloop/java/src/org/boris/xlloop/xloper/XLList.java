/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Peter Smith
 *******************************************************************************/
package org.boris.xlloop.xloper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XLList
{
    private List list = new ArrayList();

    public XLList() {
    }

    public XLList(XLArray value) {
        list.addAll(Arrays.asList(value.array));
    }

    public void add(XLoper xl) {
        list.add(xl);
    }

    public void add(String str) {
        list.add(new XLString(str));
    }

    public void add(Double value) {
        list.add(value == null ? (XLoper) XLNil.NIL : (XLoper) new XLNum(value
                .doubleValue()));
    }

    public void add(int value) {
        list.add(new XLInt(value));
    }

    public void add(double value) {
        list.add(new XLNum(value));
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public XLoper get(int index) {
        return (XLoper) list.get(index);
    }

    public XLoper toXLoper() {
        return new XLArray((XLoper[]) list.toArray(new XLoper[0]), list.size(),
                1);
    }

    public String toString() {
        return list.toString();
    }

    public static XLList make(XLoper[] args) {
        XLList l = new XLList();
        l.list.addAll(Arrays.asList(args));
        return l;
    }

    public static XLList make(XLoper arg1) {
        return make(new XLoper[] { arg1 });
    }

    public static XLList make(XLoper arg1, XLoper arg2) {
        return make(new XLoper[] { arg1, arg2 });
    }

    public static XLList make(XLoper arg1, XLoper arg2, XLoper arg3) {
        return make(new XLoper[] { arg1, arg2, arg3 });
    }

    public static XLList make(XLoper arg1, XLoper arg2, XLoper arg3, XLoper arg4) {
        return make(new XLoper[] { arg1, arg2, arg3, arg4 });
    }

    public static XLList make(XLoper arg1, XLoper arg2, XLoper arg3,
            XLoper arg4, XLoper arg5) {
        return make(new XLoper[] { arg1, arg2, arg3, arg4, arg5 });
    }
}
