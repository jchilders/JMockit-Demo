package com.initech;

public class BSupporter {
	private final int _id;

	public BSupporter(int id) {
		_id = id;
	}

	public int getId() {
		return _id;
	}

	public boolean isValid() {
		return _id % 2 == 0;
	}
}
