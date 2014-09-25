package com.mannir.zip;

import java.io.IOException;

public class ZipExample {
    public static void main(String[] args){
        ZipHelper zippy = new ZipHelper();
        try {
            zippy.zipDir("D:\\3\\mysql-mxj","D:\\3\\mysql-mxj.zip");
        } catch(IOException e2) {
            System.err.println(e2);
        }
    }
}
