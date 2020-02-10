package com.calculator.adcalc.advanced.quadratic;

import com.calculator.adcalc.advanced.CalcService;
import com.calculator.adcalc.advanced.SolverService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuadraticSolver implements QuadService {
    private double determinant;
    private double root1;
    private double root2;
    private static long ROUND_UP = 10000;

//    private QuadraticSolver(){}

    public String solve(double a, double b , double c) {
        try {
            return get_solution(a, b, c);
    }catch (NumberFormatException e){
            return (null);
        }
    }

    public String get_solution(double a, double b, double c){
        double deter = this.determinant = (b * b) - (4 * a * c);
        String output;

        if (deter > 0){
            this.root1 = ( -b  + Math.sqrt(deter )) / (2 * a);
            this.root2 = ( -b  - Math.sqrt(deter )) / (2 * a);
            output = "Root 1 is " + this.root1 + "Root 2 is " + this.root2;
        }
        else if (deter == 0){
            this.root1 = this.root2 = -b / (2 * a);

            output = "Root1 = Root2 =" + this.root1;
        }
        else {
            long real = ((long) ((-b /(2 * a)) * ROUND_UP));
            long imag =((long) ((Math.sqrt(-deter) / (2 * a)) * ROUND_UP));
            output = "Root1 = " + real + "." + imag;
        }
        return output;
    }

    // This function will return the determinant of the equation
    public double getDeterminant(){
        return this.determinant;
    }

}
