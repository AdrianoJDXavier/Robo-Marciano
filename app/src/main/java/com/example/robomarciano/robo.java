package com.example.robomarciano;

public class robo {
    private String resposta;

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public robo() {
    }

    public String responda(String pergunta) {
        if (pergunta.trim().isEmpty()) {
            return "Não me incomode";
        } else {
            if (pergunta.toLowerCase().contains("eu")) {
                return "A responsabilidade é sua";
            } else {
                if (!(pergunta.toUpperCase() == pergunta) && ("?".equals(pergunta.substring(pergunta.length() - 1)))) {
                    return "Certamente";
                } else if (pergunta.toUpperCase() == pergunta && !("?".equals(pergunta.substring(pergunta.length() - 1)))) {
                    return "Opa! Calma aí!";
                } else if ((pergunta.toUpperCase() == pergunta) && ("?".equals(pergunta.substring(pergunta.length() - 1)))) {
                    return "Relaxa!";
                } else {
                    return "Tudo bem, como quiser";
                }
            }
        }
    }
}
