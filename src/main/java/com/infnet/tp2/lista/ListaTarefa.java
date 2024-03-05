package com.infnet.tp2.lista;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private static ListaTarefa list = null;
    private List<Tarefa> tarefas;

    private ListaTarefa() {
        tarefas = new ArrayList<>();
    }

    public static ListaTarefa getInstance() {
        if (list == null) {
            list = new ListaTarefa();
        }
        return list;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void addTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

}
