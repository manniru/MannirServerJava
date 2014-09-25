package com.mannir.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.mysql.management.MysqldResource;
import com.mysql.management.MysqldResourceI;

public class EmDb {
	static String dbconfig = System.getProperty("user.dir")+"/"+"dbconfig.properties"; //D:\git\MannirServer
	static String dbtype = "mysql";
	static String dbhost = "localhost";
	static String dbport = "3336";
	static String dbname = "db1";
	static String dbuser = "olyanren";
	static String dbpass = "1987";
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    //static int port = Integer.parseInt(System.getProperty("c-mxj_test_port", dbport));
    MysqldResource mysqldResource = null;
	
	public EmDb(String dbconfig,String dbtype, String dbhost, String dbport, String dbname, String dbuser, String dbpass) {
		this.dbtype = dbtype;
		this.dbhost = dbhost;
		this.dbport = dbport;
		this.dbname = dbname;
		this.dbuser = dbuser;
		this.dbpass = dbpass;
		configure(dbconfig, dbtype, dbhost, dbport, dbname, dbuser, dbpass);
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.io.tmpdir"));
		test();

	}
	
	public void configure(String dbconfig, String dbtype, String dbhost, String dbport, String dbname, String dbuser, String dbpass) {
		try {
			PrintWriter writer = new PrintWriter(dbconfig, "UTF-8");
			writer.println("#Confiruraton Properties");
			writer.println("dbconfig="+dbconfig);
			writer.println("dbtype="+dbtype);
			writer.println("dbhost="+dbhost);
			writer.println("dbport="+dbport);
			writer.println("dbname="+dbname);
			writer.println("dbuser="+dbuser);
			writer.println("dbpass="+dbpass);
			writer.println("");
			writer.println("#eBahnIPTV Values Settings");		
			writer.println("dbconfig="+dbconfig);

			writer.close();
			System.out.println("Configuration Saved");
			} catch(Exception e2) { System.out.println(e2); }
	}
	
	Connection connect() {
		Connection conn = null;
		
		Properties prop = new Properties();
		try { InputStream in = new FileInputStream(dbconfig);
        prop.load(in); } catch(Exception e3) { System.out.println(e3); }
        
		dbhost = prop.getProperty("dbhost");
		dbport = prop.getProperty("dbport");
		dbname = prop.getProperty("dbname");
		dbuser = prop.getProperty("dbuser");
		dbpass = prop.getProperty("dbpass");
		
		try { Class.forName(DRIVER);
		String url = "jdbc:mysql://"+dbhost+":" + dbport + "/" + dbname + "?" + "createDatabaseIfNotExist=true";
			conn = DriverManager.getConnection(url, dbuser, dbpass);
			System.out.println("connected to embdedded database!");
		} catch(Exception e) { System.out.println(e); }
		return conn;
	}

	public MysqldResource startDatabase(String port, String userName, String password) {
		File ourAppDir = new File(System.getProperty(JAVA_IO_TMPDIR));
        File databaseDir = new File(ourAppDir, "mysql-mxj");
        mysqldResource = new MysqldResource(databaseDir);
        Map database_options = new HashMap();
        database_options.put(MysqldResourceI.PORT, dbport);
        database_options.put(MysqldResourceI.INITIALIZE_USER, "true");
        database_options.put(MysqldResourceI.INITIALIZE_USER_NAME, dbuser);
        database_options.put(MysqldResourceI.INITIALIZE_PASSWORD, dbpass);

        mysqldResource.start("test-mysqld-thread", database_options);
        if (!mysqldResource.isRunning()) { throw new RuntimeException("MySQL did not start."); }
        System.out.println("MySQL is running.");
        return mysqldResource;
    }
	
	public void start() {
		startDatabase(dbport, dbuser, dbpass);
	}
	
	public void stop() {
		try {
			mysqldResource.shutdown();
			System.out.println("Database Server Stop!");
			} catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void test() {
		EmDb emdb = new EmDb(dbconfig, dbtype, dbhost, dbport, dbname, dbuser, dbpass);
		emdb.start();
		Connection cn = emdb.connect();
		
		try {
		int status = cn.createStatement().executeUpdate("CREATE DATABASE db");
		System.out.println("Database Created");
		} catch(Exception e) { System.out.println(e); }
		
		try {
			String sql1 = "DROP TABLE IF EXISTS `users`";
			String sql2 = "CREATE TABLE `users` ("
					+ "`id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`username` varchar(20) DEFAULT NULL,"
					+ "`password` varchar(20) DEFAULT NULL,"
					+ "`role` varchar(20) DEFAULT NULL,"
					+ "PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;"; 
			cn.createStatement().executeUpdate(sql1);
			int status = cn.createStatement().executeUpdate(sql2);
			System.out.println("Table Created");
			} catch(Exception e) { System.out.println(e); }
		
		try { // insert
			String sql1 = "INSERT INTO `users`(username, password, role) VALUES ('admin', 'admin', 'admin')";
			String sql2 = "INSERT INTO `users`(username, password, role) VALUES ('user1', 'user1', 'user')";
			String sql3 = "INSERT INTO `users`(username, password, role) VALUES ('user2', 'user2', 'user')";

			int status = cn.createStatement().executeUpdate(sql1);
			cn.createStatement().executeUpdate(sql2);
			cn.createStatement().executeUpdate(sql3);
			System.out.println("Records Inserted:"+status);
			} catch(Exception e) { System.out.println(e); }
		
		try { // select
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM USERS"); rs.next();
			String username = rs.getString("username");
			System.out.println("username from db:"+username);
			} catch(Exception e) { System.out.println(e); }
		
		try { // update
			int status = cn.createStatement().executeUpdate("UPDATE users SET username = 'user3' WHERE username='user2'");
			System.out.println("records updated!:"+status);
			} catch(Exception e) { System.out.println(e); }
		
		try { // delete
			int status = cn.createStatement().executeUpdate("DELETE FROM users WHERE username = 'user3'");
			System.out.println("records deleted:"+status);
			} catch(Exception e) { System.out.println(e); }
		
		try { // selectall
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM USERS");
			while(rs.next()) {
				String id = rs.getString("id");
				String username = rs.getString("username");
				System.out.println(id+"=="+username);
			}
			} catch(Exception e) { System.out.println(e); }
				
		///emdb.stop();
	}

}
