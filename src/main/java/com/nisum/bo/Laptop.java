package com.nisum.bo;
 class oldClass {
String memory = "1 gb";
}
public class Laptop{
	public static void main(String[] args) {
		oldClass oc = new oldClass();
		repair(oc);
		System.out.println(oc.memory);
	}
	public static void repair(oldClass ol) {
		ol = new oldClass();
		ol.memory="2 GB";
	}
}
