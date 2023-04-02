package main.managers.history;

import main.model.Task;

import java.util.List;

public interface HistoryManager {

    List<Task> getHistory();

    void addHistory(Task task);

    void clear();

    void remove(int id);
}