package com.mannir.db;

import java.sql.Connection;

public class TestEmDb {
	static String dbconfig = System.getProperty("user.dir")+"/"+"dbconfig.properties"; //D:\git\MannirServer
	static String dbtype = "mysql";
	static String dbhost = "localhost";
	static String dbport = "3336";
	static String dbname = "db1";
	static String dbuser = "olyanren";
	static String dbpass = "1987";

	public static void main(String[] args) {
		EmDb emdb = new EmDb(dbconfig, dbtype, dbhost, dbport, dbname, dbuser, dbpass);
		emdb.start();
		Connection cn = emdb.connect();
		emdb.stop();

	}

}
