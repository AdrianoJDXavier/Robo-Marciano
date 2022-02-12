package com.example.robomarciano;

public class roboMat extends robo{
    public float responda(String pergunta, float a, float b) {
        if (null == pergunta) {
            return 0;
        } else {
            switch (pergunta) {
                case "some":
                    return a + b;
                case "subtrai":
                    return a - b;
                case "multiplique":
                    return a * b;
                case "divide":
                    return a / b;
                default:
                    return 0;
            }
        }
    }
}
