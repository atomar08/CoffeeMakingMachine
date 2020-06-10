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
public interface CmmIF 
{
    public void setCoffeeType(String str);
    public void setGrindingTime(int secs);
//    public void addCondiment(Condiment type);
    public void addCondiment(CoffeeIF type);
    public void setTemperature(int degree);
    public void holdTemperature(int seconds);
    public void wait(int seconds);
    public void setPowerLED (int num);
    public void setTypeLED (int num);
    public double computePrice(CoffeeIF cif); 
    public void done( );
    public void run(CmmProgram cif);
//    public void saleRecord(CmmProgram cif);
    public void saleRecord();
}
