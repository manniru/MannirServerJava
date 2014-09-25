package com.mannir.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
 
public class UnZip
{
    List<String> fileList;
    private static final String INPUT_ZIP_FILE = "D:\\3\\mysql-mxj.zip";
    private static final String OUTPUT_FOLDER = "D:\\3\\mysqlDB";
 
    public static void main( String[] args ) {
    	//boolean del1 = new File("D:\\3\\mysqlDB2").delete();
    	
    	UnZip unZip = new UnZip();
    	unZip.unZipIt(INPUT_ZIP_FILE,OUTPUT_FOLDER);

    	File sourceDir = new File("D:\\3\\mysqlDB\\mysql-mxj");
    	File targetDir = new File("D:\\3\\mysqlDB2");
    	try { FileUtils.moveDirectory(sourceDir, targetDir);
    	} catch (IOException e) { e.printStackTrace(); }
    	
    	targetDir.delete();
    	
    	
    	
    }
 
    /**
     * Unzip it
     * @param zipFile input zip file
     * @param output zip file output folder
     */
    public void unZipIt(String zipFile, String outputFolder){
 
     byte[] buffer = new byte[1024];
 
     try{
 
    	//create output directory is not exists
    	File folder = new File(OUTPUT_FOLDER);
    	if(!folder.exists()){
    		folder.mkdir();
    	}
 
    	//get the zip file content
    	ZipInputStream zis = 
    		new ZipInputStream(new FileInputStream(zipFile));
    	//get the zipped file list entry
    	ZipEntry ze = zis.getNextEntry();
 
    	while(ze!=null){
 
    	   String fileName = ze.getName();
           File newFile = new File(outputFolder + File.separator + fileName);
 
           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
 
            //create all non exists folders
            //else you will hit FileNotFoundException for compressed folder
            new File(newFile.getParent()).mkdirs();
 
            FileOutputStream fos = new FileOutputStream(newFile);             
 
            int len;
            while ((len = zis.read(buffer)) > 0) {
       		fos.write(buffer, 0, len);
            }
 
            fos.close();   
            ze = zis.getNextEntry();
    	}
 
        zis.closeEntry();
    	zis.close();
 
    	System.out.println("Done");
 
    }catch(IOException ex){
       ex.printStackTrace(); 
    }
   }    
}