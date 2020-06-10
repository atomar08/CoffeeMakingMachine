/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542lab9;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author atomar
 */
public class CmmEnv implements CmmIF{
     
    private int degree, seconds, num;
    List<CoffeeIF> condimentList, coffeeSaleList;
//    private CmmProgram cmm;
    
    public CmmEnv()
    {
    	degree = 0;
    	seconds = 0;
    	num = 0;
        condimentList = new LinkedList<CoffeeIF>();
        coffeeSaleList = new LinkedList<CoffeeIF>();
    }
    
    @Override
    public void setTemperature(int degree) {
     System.out.println("set temprature:" + degree + " degree F");
     this.degree=degree;
    }

    @Override
    public void holdTemperature(int seconds) {
      System.out.println("hold temprature: " + seconds + " seconds");
      this.seconds=seconds;
    }

    @Override
    public void wait(int seconds) {
        System.out.println("wait for: " + seconds + " seconds");
        this.seconds=seconds;
        try {
//            Thread.sleep(15000); 
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(CmmEnv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setPowerLED(int num) {
      System.out.println("Machine led set to: " + num);
      this.num=num;
    }

    @Override
    public void setTypeLED(int num) {
      System.out.println("coffee type is: " +num);
      this.num=num;
    }

    @Override
    public void setCoffeeType(String str) {
      System.out.println("Type of coffee selected: " +str);   
    }

    @Override
    public void setGrindingTime(int secs) {
      System.out.println("set grinding time: " + secs + " seconds");
    }

    @Override
    public void run(CmmProgram cif) {
        cif.start();
    }
    
    @Override
    public void addCondiment(CoffeeIF coffeeIFObj) {
        condimentList.add(coffeeIFObj);
        System.out.println("price of adding " + coffeeIFObj.getName() + " condiment is: $"+ coffeeIFObj.getPrice());
    }
    
    @Override
    public double computePrice(CoffeeIF cif) {
        double totalCost = 0;
        Iterator<CoffeeIF> condimentIterator = condimentList.iterator();
        while(condimentIterator.hasNext())
        {
            totalCost = totalCost + condimentIterator.next().getPrice();  
        }
        condimentList.clear();
        System.out.println("price of adding condiment are: $"+ totalCost);
        return totalCost;
    }

    public void addSaleItem(CoffeeIF coffeeIFObj)
    {
    	coffeeSaleList.add(coffeeIFObj);
    }
    
    public void saleRecord() {
    	double totalCost = 0;
    	CoffeeIF coffeeObj;
    	System.out.println("Sale record:");
        Iterator<CoffeeIF> coffeeSaleIterator = coffeeSaleList.iterator();
        while(coffeeSaleIterator.hasNext())
        {
        	coffeeObj = coffeeSaleIterator.next();
        	System.out.println("item sold: " + coffeeObj.getName() + " at $" + coffeeObj.getPrice());
            totalCost = totalCost + coffeeObj.getPrice();  
        }
        System.out.println("Total sale cost: "+ totalCost);
//        return totalCost;
    }
    
    @Override
    public void done() {
      System.out.println("task done"); 
    }

    
}