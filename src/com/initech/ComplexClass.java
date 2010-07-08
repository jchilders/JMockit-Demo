package com.initech;

import java.util.ArrayList;
import java.util.List;

public class ComplexClass {
    private final List<ASupporter> _aList;

    public ComplexClass() {
        _aList = new ArrayList<ASupporter>();
    }

    public boolean addSupporter(ASupporter newA) {
        return _aList.add(newA);
    }

    public int size() {
        return _aList.size();
    }

    public boolean bSupporterValidator(int id) {
        BSupporter bSupp = new BSupporter(id);
        return bSupp.isValid();
    }

    public boolean isValid() {
        for (ASupporter aSupporter : _aList) {
            if (!aSupporter.isValid()) {
                return false;
            }
        }

        return true;
    }

    public boolean persist() {
        notifyEveryone(1);
        return Database.persist(this);
    }

    private static final boolean notifyEveryone(int priority) {
        System.out.println("Hey you, a ComplexObject was persisted. Priority "
                + priority + "!");
        return priority % 2 == 0;
    }
}
