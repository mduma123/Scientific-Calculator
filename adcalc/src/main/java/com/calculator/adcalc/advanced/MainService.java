package com.calculator.adcalc.advanced;

import com.calculator.adcalc.advanced.quadratic.QuadService;
import com.calculator.adcalc.advanced.quadratic.QuadraticSolver;
import com.calculator.adcalc.advanced.trig.TrigService;
import com.calculator.adcalc.advanced.trig.TrigSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class MainService implements CalcService {
    @Autowired
    private TrigService serveTrigSolver;
    @Autowired
    private QuadService serveQuadSolver;

    @Override
    public String quadSolver(double a, double b, double c){
        return serveQuadSolver.solve(a, b, c);
    }
    @Override
    public String trigSolver(double num, char op){
       return serveTrigSolver.solve(num, op);
    }
}
