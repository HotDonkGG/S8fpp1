package main.server;

import com.google.gson.*;
import main.managers.Managers;
import main.managers.task.FileBackedTasksManager;
import main.managers.task.TaskManager;
import main.model.Epic;
import main.model.Task;
import main.model.SubTask;
import main.model.enums.TaskStatus;
import main.server.KVTaskClient;

import java.io.IOException;
import java.util.List;

public class HttpTaskManager extends FileBackedTasksManager {

    private  KVTaskClient taskClient;
    private static String uri = "http://localhost:8078";
    private static Gson gson = Managers.getGson();

    public HttpTaskManager() {

            taskClient = new KVTaskClient(uri);

    }

    @Override
    public Task getTaskById(Integer id) {
        try {
            return gson.fromJson(taskClient.load(id.toString()),Task.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Epic getEpicById(Integer id){
        try {
            return gson.fromJson(taskClient.load(id.toString()),Epic.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public SubTask getSubTaskById(Integer id){
        try {
            return gson.fromJson(taskClient.load(id.toString()),SubTask.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Epic removeEpicById(Integer id){
        try {
            return gson.fromJson(taskClient.load(id.toString()),Epic.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



//    List<Epic> getAllEpic();
//
//    void clearEpic();
//
//
//
//    Epic addEpic(Epic epic);
//
//    void updateEpic(Epic epic);
//
//
//
//    List<SubTask> getAllSubTask();
//
//    void clearSubtask();
//
//    SubTask getSubTaskById(Integer id);
//
//    SubTask addSubTask(SubTask subTask);
//
//    SubTask removeSubTaskById(Integer id);
//
//    SubTask updateSubTask(SubTask subTask);
//
//    List<Task> getAllTask();
//
//    void clearTask();
//
//
//    void updateStatusEpic(Epic epic, TaskStatus taskStatus);
//
//    Task addTask(Task task);
//
//    Task removeTaskById(Integer id);
//
//    void updateTask(Task task);

 //   List<SubTask> getAllSubtaskByEpic(Epic epic);

//    public static HttpTaskManager loadFromServer() {
//        TaskManager manager = Managers.getManagerDefault();
//        try {
//            JsonElement jsonElementForTask = JsonParser.parseString(taskClient.load("task"));
//            JsonArray arrayTask = jsonElementForTask.getAsJsonArray();
//            for (JsonElement jsonTsk : arrayTask) {
//                manager.addTask(gson.fromJson(jsonTsk, Task.class));
//            }
//            JsonElement jsonElementForEpic = JsonParser.parseString(taskClient.load("epic"));
//            JsonArray arrayEpic = jsonElementForEpic.getAsJsonArray();
//            for (JsonElement jsonTsk : arrayEpic) {
//                manager.addEpic(gson.fromJson(jsonTsk, Epic.class));
//            }
//            JsonElement jsonElementForSubtask = JsonParser.parseString(taskClient.load("subtask"));
//            JsonArray arraySubtask = jsonElementForSubtask.getAsJsonArray();
//            for (JsonElement jsonTsk : arraySubtask) {
//                manager.addSubTask(gson.fromJson(jsonTsk, SubTask.class));
////                SubTask subtask = gson.fromJson(jsonTsk, SubTask.class);
////                manager.saveSubtask(subtask, subtask.getEpicId());
//            }
//            JsonElement jsonElementForHistory = JsonParser.parseString(taskClient.load("history"));
//            JsonArray arrayHistory = jsonElementForHistory.getAsJsonArray();
//            for (JsonElement jsonHistory : arrayHistory) {
//                JsonObject objectHistory = jsonHistory.getAsJsonObject();
//                String typeHistory = objectHistory.get("type").getAsString();
//                if (typeHistory.equals("TASK")) {
//                    Task taskForHistory = gson.fromJson(objectHistory, Task.class);
//                    manager.getAllTask().add(taskForHistory);
//                }
//                if (typeHistory.equals("EPIC")) {
//                    Epic epicForHistory = gson.fromJson(objectHistory, Epic.class);
//                    manager.getAllEpic().add(epicForHistory);
//                }
//                if (typeHistory.equals("SUBTASK")) {
//                    SubTask subtaskForHistory = gson.fromJson(objectHistory, SubTask.class);
//                    manager.getAllSubTask().add(subtaskForHistory);
////                    manager.getHistoryManager().add(subtaskForHistory);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return (HttpTaskManager) manager;
//    }

//    @Override
//    public void save() {
//        try {
//            String tasks = gson.toJson(getAllTask());
//            taskClient.put("task", tasks);
//
//            String epics = gson.toJson(getAllEpic());
//            taskClient.put("epic", epics);
//
//            String subtasks = gson.toJson(getAllSubTask());
//            taskClient.put("subtask", subtasks);
//
//            String history = gson.toJson(historyManager);
//            taskClient.put("history", history);
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
