package main.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.managers.history.InMemoryHistoryManager;
import main.managers.task.FileBackedTasksManager;
import main.managers.history.HistoryManager;
import main.managers.task.InMemoryTaskManager;
import main.managers.task.TaskManager;
import main.server.HttpTaskManager;

import java.time.LocalDateTime;

public class Managers {

    public static HistoryManager getHistoryManager(){
        return  new InMemoryHistoryManager();
    }
    public static FileBackedTasksManager getFileBackendManager(){
        return new FileBackedTasksManager();
    }
    public static TaskManager getManagerDefault(){
        return new HttpTaskManager();
    }
    public static Gson getGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
       // gsonBuilder.registerTypeAdapter(LocalDateTime.class);
        return gsonBuilder.create();
    }
}
