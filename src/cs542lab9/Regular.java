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

import java.util.Scanner;

/**
 *
 * @author atomar
 */
public class Regular extends CmmProgram{
    private CoffeeName name;
    private int price;
    private CmmEnv env;
    private CoffeeIF cif;
    private CmmProgram cmm;
    

    public Regular(CmmEnv _env)
    {   price = 1;
        name = CoffeeName.Regular;
        env = _env;
    }
    
    public void setEnvironment(CmmIF environment) 
    {
       // env.setGrindingTime(8 );
    }
    
    public CmmIF getEnvironment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public  void getName() {
        System.out.println("You have selected coffee: "+ name );
    }

    public  int getPrice() {
        System.out.println("price of coffee is $" + price); //To change body of generated methods, choose Tools | Templates.
        return price;
    }

    @Override
    public void start() {
        env.setCoffeeType(this.name.toString());
        env.setPowerLED(0);
        env.setTypeLED(1);
        env.setGrindingTime(8);
        env.setTemperature(150);
        env.holdTemperature(2);
        env.wait(15);
        env.setPowerLED(1);

        System.out.println("---------------------------");

        boolean condiments_flag = true;
        Scanner input;
        String name;
        cmm = new Regular(env);
        CoffeeIF coffeeObj = new CoffeeIF(this.name.toString(), cmm.getPrice());
        env.addSaleItem(coffeeObj);
        
        while(condiments_flag)
        {
            System.out.println("Do you want to add condiments");
            System.out.println("Enter \n 0: Finish/No Condiments \n 1: Cream\n 2: Vanilla \n 3: Choclate");
            input=new Scanner(System.in); 
            name = input.nextLine();
            
            if(name.equalsIgnoreCase("0"))
            {
                condiments_flag = false;
//                System.out.println("total sell record is" + env.saleRecord());
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
       env.done();
    }
}