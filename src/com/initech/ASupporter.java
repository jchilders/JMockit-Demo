package com.initech;

import java.util.ArrayList;
import java.util.List;

public class ASupporter {
	private final List<BSupporter> _bList = new ArrayList<BSupporter>();

	public BSupporter getBSupporter(int bId) {
		for (BSupporter bSupp : _bList) {
			if (bSupp.getId() == bId) {
				return bSupp;
			}
		}

		return null;
	}

	public boolean addBSupporter(BSupporter newB) {
		return _bList.add(newB);
	}

	public boolean removeBSupporter(BSupporter oldB) {
		return _bList.remove(oldB);
	}

	public boolean isValid() {
		for (BSupporter bSupp : _bList) {
			if (!bSupp.isValid()) {
				return false;
			}
		}

		return true;
	}
}
