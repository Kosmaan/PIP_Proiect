package ro.tuiasi.ac.Proiect_PIP;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, InvalidFormatException, IOException
    {
    	
    	Interfata i = new Interfata();
    	i.initInterface();
    	
    }
}