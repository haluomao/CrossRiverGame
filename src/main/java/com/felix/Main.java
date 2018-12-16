package com.felix;

import java.util.Arrays;
import java.util.Scanner;

import com.felix.facade.IFacade;
import com.felix.facade.FacadeImpl;

/**
 * The entrance of game, welcome!
 *
 * @author Felix
 */
public class Main {
    public static void main(String[] args) {
        IFacade facade = new FacadeImpl();
        while (true) {
            facade.show();
            Scanner sc = new Scanner(System.in);
            System.out.print("Onboard：");
            String[] tigers = sc.nextLine().split(" ");
            if (tigers.length > 2 || tigers.length < 1) {
                System.out.println("Wrong input!");
                continue;
            }
            facade.sail(Arrays.asList(tigers));
            System.out.println();
        }
    }
}
