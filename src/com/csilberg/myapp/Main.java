package com.csilberg.myapp;

import com.csilberg.calcengine.CalculateHelper;
import com.csilberg.calcengine.DynamicHelper;
import com.csilberg.calcengine.InvalidStatementException;
import com.csilberg.calcengine.MathEquation;
import com.csilberg.calcengine.CalculateBase;
import com.csilberg.calcengine.Adder;
import com.csilberg.calcengine.MathProcessing;
import com.csilberg.calcengine.PowerOf;
import com.csilberg.calcengine.Subtracter;
import com.csilberg.calcengine.Multiplier;
import com.csilberg.calcengine.Divider;


public class Main {

                    public static void main(String[] args) {
//                        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
//                        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
//
//                        char[] opCodes = {'d', 'a', 's', 'm'};
//                        double [] results = new double[opCodes.length];
//
//                  useMathEquation();
//                  useCalculatorBase();
//                  useCalculatorHelper()
                        String[] statements = {
                            "add 25.0 92.0",
                            "power 5.0 2.0"
                        };
                        DynamicHelper helper = new DynamicHelper(new MathProcessing[]{
                                new Adder(),
                                new PowerOf()
                        } );

                        for (String statement:statements) {
                            String output = helper.process(statement);
                            System.out.println(output);
                        }
                    }

                    static void useCalculatorHelper() {
                        String[] statements = {
                                "add 1.0",
                                "add xx 25.0",
                                "addX 0.0 0.0",
                                "divide 100.0 50.0",
                                "add 25.0 92.0",
                                "subtract 225.0 17.0",
                                "multiply 11.0 3.0"
                        };

                        CalculateHelper helper = new CalculateHelper();
                        System.out.println("--- via helper");
                        for (String statement : statements) {
                            try {
                                    helper.process(statement);
                                    System.out.println(helper);
                            }   catch(InvalidStatementException e) {
                                    System.out.println(e.getMessage());
                                    if (e.getCause() != null)
                                        System.out.println("  Original exception: " + e.getCause().getMessage());
                            }
                        }
                        System.out.println("--- end");
                    }


                    public static void useMathEquation() {
                        MathEquation[] mathEquations = new MathEquation[4];

                        mathEquations[0] = new MathEquation('d', 100.0d, 50.0d);
                        mathEquations[1] = new MathEquation('a', 25.0d, 92.0d);
                        mathEquations[2] = new MathEquation('s', 225.0d, 17.0d);
                        mathEquations[3] = new MathEquation('m', 11.0d, 3.0d);

                        for (MathEquation mathEquation : mathEquations) {
                            mathEquation.execute();
                            System.out.print("Result = ");
                            System.out.println(mathEquation.getResult());
                        }

                        System.out.println();
                        System.out.println("Using Overload");

                        MathEquation equationOverload = new MathEquation('d');
                        double leftDouble = 9.0d;
                        double rightDouble = 4.0d;

                        equationOverload.execute(leftDouble, rightDouble);

                        System.out.print("Ovrld Dbl Result = ");
                        System.out.println(equationOverload.getResult());

                        int leftInt = 9;
                        int rightInt = 4;

                        equationOverload.execute(leftInt, rightInt);

                        System.out.print("Ovrld Int Result = ");
                        System.out.println(equationOverload.getResult());

                        equationOverload.execute((double) leftInt, rightInt);

                        System.out.print("Ovrld Dbl/Int Result = ");
                        System.out.println(equationOverload.getResult());

                        System.out.println();
                        System.out.println("Using Inheritance");
                    }

                    public static void useCalculatorBase() {

                        CalculateBase[] calculators = {
                                new Divider(100.0d, 50.0d),
                                new Adder(25.0d, 92.0d),
                                new Subtracter(225.0d, 17.0d),
                                new Multiplier(11.0d, 3.0d)
                        };

                        for (CalculateBase calculator : calculators) {
                            calculator.calculate();
                            System.out.print("result = ");
                            System.out.println(calculator.getResult());
                        }
                        System.out.println();
                        System.out.println("---------End----------");

                    }
                }

