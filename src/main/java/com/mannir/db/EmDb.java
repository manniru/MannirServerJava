package com.mannir.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.mysql.management.MysqldResource;
import com.mysql.management.MysqldResourceI;

public class EmDb {
	static String dbtype = "mysql";
	static String dbhost = "localhost";
	static String dbport = "3336";
	static String dbname = "db1";
	static String dbuser = "olyanren";
	static String dbpass = "1987";
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    static int port = Integer.parseInt(System.getProperty("c-mxj_test_port", dbport));
    MysqldResource mysqldResource = null;
	
	public EmDb(String dbtype, String dbhost, int dbport, String dbname, String dbuser, String dbpass) {
		this.dbtype = dbtype;
		this.dbhost = dbhost;
		this.dbport = dbport+"";
		this.dbname = dbname;
		this.dbuser = dbuser;
		this.dbpass = dbpass;
	}

	public static void main(String[] args) {
		EmDb emdb = new EmDb(dbtype, dbhost, port, dbname, dbuser, dbpass);
		emdb.start();
		Connection cn = emdb.connect();
		emdb.stop();

	}
	
	private Connection connect() {
		Connection conn = null;
		try { Class.forName(DRIVER);
		String url = "jdbc:mysql://localhost:" + port + "/" + dbname + "?" + "createDatabaseIfNotExist=true";
			conn = DriverManager.getConnection(url, dbuser, dbpass);
			System.out.println("connected to embdedded database!");
		} catch(Exception e) { System.out.println(e); }
		return conn;
	}

	public MysqldResource startDatabase(int port, String userName, String password) {
		File ourAppDir = new File(System.getProperty(JAVA_IO_TMPDIR));
        File databaseDir = new File(ourAppDir, "mysql-mxj");
        mysqldResource = new MysqldResource(databaseDir);
        Map database_options = new HashMap();
        database_options.put(MysqldResourceI.PORT, Integer.toString(port));
        database_options.put(MysqldResourceI.INITIALIZE_USER, "true");
        database_options.put(MysqldResourceI.INITIALIZE_USER_NAME, userName);
        database_options.put(MysqldResourceI.INITIALIZE_PASSWORD, password);

        mysqldResource.start("test-mysqld-thread", database_options);
        if (!mysqldResource.isRunning()) { throw new RuntimeException("MySQL did not start."); }
        System.out.println("MySQL is running.");
        return mysqldResource;
    }
	
	public void start() {
		startDatabase(port, dbuser, dbpass);
	}
	
	public void stop() {
		try {
			mysqldResource.shutdown();
			System.out.println("Databse Server Stop!");
			} catch (Exception e) { e.printStackTrace(); }
	}

}
