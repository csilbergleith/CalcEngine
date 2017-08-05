package com.csilberg.calcengine;

                public class Main {

                    public static void main(String[] args) {
//                        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
//                        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
//
//                        char[] opCodes = {'d', 'a', 's', 'm'};
//                        double [] results = new double[opCodes.length];

                        MathEquation[]  mathEquations = new MathEquation[4];

                        mathEquations[0] = new MathEquation('d', 100.0d, 50.0d);
                        mathEquations[1] = new MathEquation('a', 25.0d, 92.0d );
                        mathEquations[2] = new MathEquation('s',225.0d, 17.0d );
                        mathEquations[3] = new MathEquation('m',11.0d, 3.0d );

                        for (MathEquation mathEquation: mathEquations) {
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

                        equationOverload.execute( leftInt, rightInt);

                        System.out.print("Ovrld Int Result = ");
                        System.out.println(equationOverload.getResult());

                        equationOverload.execute((double) leftInt, rightInt);

                        System.out.print("Ovrld Dbl/Int Result = ");
                        System.out.println(equationOverload.getResult());

                        System.out.println();
                        System.out.println("---------End----------");

                }

//                    public static MathEquation create(double leftVal, double rightVal, char opCode) {
//                        MathEquation equation = new MathEquation(opCode,leftVal, rightVal );
//                        equation.setLeftVal(leftVal);
//                        equation.setRightVal(rightVal);
//                        equation.setOpCode(opCode);
//
//                        return equation;
//                    }
}
