/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs542lab9;

import java.util.Scanner;

/**
 *
 * @author atomar
 */
public class Latte extends CmmProgram{
    private int price;
    private CoffeeName name;
    private CmmEnv _env;
    private CoffeeIF cif;
    private CmmProgram cmm;
    
    
   public Latte(CmmEnv _env)
    {   price=1;
        name = CoffeeName.LATTE;
        env=_env;
    }
    
    public void setEnvironment(CmmIF environment) 
    {
       // env.setGrindingTime(8 );
        
    }
    
    public CmmIF getEnvironment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public  void getName()
    {
        System.out.println("You have selected coffee:"+ name );
       // return this.name;
       // 
    }

    public  int getPrice() {
        System.out.println("price is" + price); //To change body of generated methods, choose Tools | Templates.
        return price;
    }



    @Override
    public void start() {
        
      env.setCoffeeType(this.name.toString());
        env.setPowerLED(0);
        env.setTypeLED(1);
        env.setGrindingTime(10);
        env.setTemperature(140);
        env.holdTemperature(2);
        env.wait(15);
        env.setPowerLED(1);
      
        System.out.println("---------------------------");
      
        boolean condiments_flag = true;
        System.out.println("Do you want to add condiments");
        Scanner input;
        String name;
        cmm =new Latte(env);
        CoffeeIF coffeeObj = new CoffeeIF(this.name.toString(), cmm.getPrice());
        env.addSaleItem(coffeeObj);
        
        while(condiments_flag)
        {
            System.out.println("Enter 0: No Condiments \n 1: Cream\n 2: Vanilla \n 3: Choclate");
            input=new Scanner(System.in); 
            name = input.nextLine();
            
            if(name.equalsIgnoreCase("0"))
            {
                condiments_flag = false;
                 cmm.getPrice();
            }
            else if(name.equalsIgnoreCase("1"))
            {
                CondimentIF condiment = new Cream();
                CoffeeIF condObj = new CoffeeIF(condiment.getCondimentType(), condiment.getPrice());
                env.addCondiment(condObj);
                env.addSaleItem(condObj);
            }
            else if(name.equalsIgnoreCase("2"))
            {
                CondimentIF condiment = new Vanilla();
              
                CoffeeIF condObj = new CoffeeIF(condiment.getCondimentType(), condiment.getPrice());
                env.addCondiment(condObj);
                env.addSaleItem(condObj);
            }
            else if(name.equalsIgnoreCase("3"))
            {
                CondimentIF condiment = new Choclate();
             
                CoffeeIF condObj = new CoffeeIF(condiment.getCondimentType(), condiment.getPrice());
                env.addCondiment(condObj);
                env.addSaleItem(condObj);
            }
            else 
            {
                System.out.println("Wrong selection, please select 0 to finalize");
            }
        }
      
       env.computePrice(cif);
      // env.saleRecord(cmm);
       env.done();
    }
    
    
    
}
