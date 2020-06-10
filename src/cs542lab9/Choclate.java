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
public class Choclate implements CondimentIF {

    @Override
    public double getPrice() {
        return 1.0;
    }

    @Override
    public String getCondimentType() {
        return CondimentType.CHOCLATE.toString();
    }
    
}
