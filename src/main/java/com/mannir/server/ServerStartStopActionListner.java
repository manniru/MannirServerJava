package com.mannir.server;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mannir.db.EmDb;

public class ServerStartStopActionListner implements ActionListener {
	EmDb emdb;
	private final JettyServer jettyServer;
	public ServerStartStopActionListner(JettyServer jettyServer) {
		this.jettyServer = jettyServer;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String dbconfig = System.getProperty("user.dir")+"/"+"dbconfig.properties";
		emdb = new EmDb(dbconfig, "mysql", "localhost", "3336", "db1", "olyanren", "1987");
		 
		 JButton btnStartStop =  (JButton) actionEvent.getSource();
		 if(jettyServer.isStarted()){
			 btnStartStop.setText("Stopping...");
			 btnStartStop.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			 
			 try { emdb.stop(); } catch (Exception exception) { exception.printStackTrace(); }
			 
			 try { jettyServer.stop(); } catch (Exception exception) { exception.printStackTrace();}
			 btnStartStop.setText("Start");
			 btnStartStop.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		 }
		 else if(jettyServer.isStopped()){

			 btnStartStop.setText("Starting...");
			 btnStartStop.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			 
			 try {
				 emdb.start();
				 } catch (Exception exception) { exception.printStackTrace(); }

			 
			 try { jettyServer.start(); } catch (Exception exception) { exception.printStackTrace(); }
			 
			 btnStartStop.setText("Stop");
			 btnStartStop.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		 }
	}
}
