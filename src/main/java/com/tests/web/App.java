package com.tests.web;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	File file = new File("src/main/resources/new.file");
    	String absoluteProjFilePath = file.getAbsolutePath();
		System.out.println(absoluteProjFilePath);
		System.out.println(file.canRead());
    }
}
