package com.calculator.adcalc.advanced.trig;

import com.calculator.adcalc.advanced.CalcService;
import com.calculator.adcalc.advanced.SolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TrigSolver implements TrigService {

    @Override
    public String solve(double num, char op){
        String output;

        switch (op){
            case 's':
                output = String.valueOf((Math.sin(num)));
                break;
            case 'c':
                output = String.valueOf((Math.cos(num)));
                break;
            case 't':
                output = String.valueOf((Math.tan(num)));
                break;
            default:
                output = "error";
                break;
        }
       if (output.equals("error"))
           return null;
       return output;
    }
}
