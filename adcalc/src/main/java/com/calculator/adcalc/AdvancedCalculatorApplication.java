package com.calculator.adcalc;

import ch.qos.logback.core.Layout;
import com.calculator.adcalc.advanced.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.calculator.adcalc.advanced.quadratic.QuadraticSolver;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//@SpringBootApplication
//public class AdvancedCalculatorApplication extends JFrame {

//    private QuadraticSolver solver = new QuadraticSolver();
//
//    public AdvancedCalculatorApplication(){
//        initUI();
//    }
//
//    private void initUI(){
//        JButton quitButton = new JButton(solver.solve(2.5, 2.8,1.3));
//
//        quitButton.addActionListener((ActionEvent) -> {
//            System.exit(0);
//        });
//
//        createLayout(quitButton);
//
//        setTitle("Quit Button");
//        setSize(300, 300);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    private void createLayout(JComponent... arg){
//        Container pane = getContentPane();
//        GroupLayout gl = new GroupLayout(pane);
//        pane.setLayout(gl);
//
//        gl.setAutoCreateContainerGaps(true);
//        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent((arg[0])));
//
//        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg[0]));
//
//}
//
//    public static void main(String[] arg){
//        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(AdvancedCalculatorApplication.class).headless(false).run(arg);
//
//        EventQueue.invokeLater(() -> {
//            AdvancedCalculatorApplication ex = ctx.getBean(AdvancedCalculatorApplication.class);
//            ex.setVisible(true);
//        });
//    }
//

//}


@SpringBootApplication
public class AdvancedCalculatorApplication extends JFrame implements CommandLineRunner{

    public static void main(String[] args){
        SpringApplication.run(AdvancedCalculatorApplication.class, args);

    }
    @Autowired
    private CalcService calcService;

    @Override
    public void run(String... arg) throws Exception{
//        System.out.println(getCalcService().solve());
        JButton quitButton = new JButton(this.calcService.quadSolver(12, 28, 2.34));


        quitButton.addActionListener((ActionEvent) -> {
//            System.exit(0);
            quitButton.setText(this.calcService.quadSolver(12,15.34, 1231));
        });

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent((quitButton)));

        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(quitButton));
        setTitle("Quit Button");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
