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
public class CoffeeIF {
    public String name;
    private double price;
    
    public CoffeeIF(String _name, double _price)
    {
        name = _name;
        price = _price;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public String getName()
    {
        return this.name;
    }
}
