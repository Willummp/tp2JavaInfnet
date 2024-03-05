package com.infnet.tp2.gerenciador;

import java.time.LocalDate;

public class Pontos {
    private int pontos;
    private LocalDate lastDay;
    private int tarefasConcluidasNoDia;

    public Pontos() {
        this.pontos = 0;
        this.lastDay = LocalDate.now();
        this.tarefasConcluidasNoDia = 0;
    }

    public int getPontos() {
        return pontos;
    }

    public LocalDate getLastDay() {
        return lastDay;
    }

    public void setDay(LocalDate ultimoDia) {
        this.lastDay = ultimoDia;
        this.tarefasConcluidasNoDia = 0;
    }

    public void atualizarPontuacao(boolean tarefaConcluida) {
        LocalDate hoje = LocalDate.now();
        if (hoje.equals(lastDay)) {
            if (tarefaConcluida) {
                tarefasConcluidasNoDia++;
                pontos++;
                if (tarefasConcluidasNoDia == 3) {
                    pontos++;
                } else if (tarefasConcluidasNoDia == 5) {
                    pontos += 2;
                }
            }
        } else {
            if (tarefasConcluidasNoDia == 0 && !tarefaConcluida) {
                pontos--;
            }
        }
        lastDay = hoje;
    }

}
