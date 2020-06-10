/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542lab9;

/**
 *
 * @author atomar
 */
public abstract class CmmProgram {
   
    CmmEnv env;
    private  String name;
    private int price;
    CmmIF environment; 
    CoffeeIF cif;
    
    public void setEnvironment(CmmIF environment)
    {
        this.environment = environment;
    } 
    
    public CmmIF getEnvironment()
    {       
        return environment;   
    } // getEnvironment()
    
     public  void setName(String name)
    { 
        this.name=name;  
    }

    public  void getName()
    {
        System.out.println("You have selected coffee:"+ name ); 
    }
   
    public  void start()
    {
        System.out.println("Mode is "+ name);
    }

    public void setPrice(int price) {
       this.price=price;
    }

    public int getPrice() {
        System.out.println("price of this coffee is $: " + price); //To change body of generated methods, choose Tools | Templates.
        return price;
    }
    
    
}
