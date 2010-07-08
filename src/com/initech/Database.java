package com.initech;

public class Database {
	public static boolean persist(ComplexClass complexClass) {
		if (null == complexClass) {
			return false;
		}

		System.out.println("Data was persisted.");

		return true;
	}
}
