package ro.tuiasi.ac.Proiect_PIP;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, InvalidFormatException, IOException
    {
    	Scriere s = new Scriere();
    	//s.replaceText();
    	
    	Citire c = new Citire();
    	c.citireGrupe(3);
    	System.out.println(c.grupe);
    	
    	Interfata i = new Interfata();
    	i.initInterface();
    }
}