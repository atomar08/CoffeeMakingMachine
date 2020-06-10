/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author atomar
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CmmIF cmmif;
      
        CmmProgram cmmProgram;
        CmmEnv cmmenv=new CmmEnv();
     
        //Regular r;
                
        Mocha m;
        Espresso e;
        Cappuccino c;
        Latte l;
      
      //  cmmenv=new CmmEnv();
        
         while(true)
        {
        	System.out.println("Welcome to coffee making select your choice");
        	System.out.println("Select coffee choice:\n Regular/Lattee/Espresso/Capachinno/Mocha/Exit");
        
        	Scanner input = new Scanner(System.in); 
        	String name= input.nextLine();
     
        	if(name.equalsIgnoreCase("Regular"))
        	{  
        		cmmProgram = new Regular(cmmenv);
        		cmmenv.run(cmmProgram);
        	}
        	else if(name.equalsIgnoreCase("mocha")) {
        		cmmProgram = new Mocha(cmmenv);
        		cmmenv.run(cmmProgram);
        	}         
        	else if(name.equalsIgnoreCase("lattee")) {
        		cmmProgram=new Latte(cmmenv);
        		cmmenv.run(cmmProgram);
        	}
        	else if(name.equalsIgnoreCase("Espresso")) {
        		cmmProgram=new Espresso(cmmenv);
        		cmmenv.run(cmmProgram);
        	}
        	else if(name.equalsIgnoreCase("Cappuccino")) {
        		cmmProgram=new Cappuccino(cmmenv);
        		cmmenv.run(cmmProgram);
        	}
        	else if(name.equalsIgnoreCase("exit")) {
        		cmmenv.saleRecord();
        		System.out.println("Exiting");
        		//System.exit(1);
                        break;
        	}
        	else 
        	{
        		System.out.println("not specific");
        	}
        
        }//end of while loop
        
    }
}

    


        