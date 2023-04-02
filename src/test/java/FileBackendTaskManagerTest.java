import main.managers.Managers;
import main.managers.task.FileBackedTasksManager;
import main.model.exception.ManagerSaveException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FileBackendTaskManagerTest extends TaskManagerTest<FileBackedTasksManager>{
    private Path filePath = Path.of("src/java.main/resources/results.csv");
    @BeforeEach
    public void loadInitialConditions() {

        manager = Managers.getFileBackendManager();

    }

//    @Test
//    public void loadFromFileTest() {
//
//        var task1 = manager.addTask(newTask());
//        var epic1 = manager.addEpic(newEpic());
//        var subtask1 = manager.addSubTask(newSubtask(epic1));
//
//        manager.getTaskById(task1.getId());
//        manager.getEpicById(epic1.getId());
//        manager.getSubTaskById(subtask1.getId());
//        manager = FileBackedTasksManager.loadFromFile(filePath);
//
//        assertEquals(Map.of(task1.getId(), task1), manager.getAllTask());
//        assertEquals(Map.of(epic1.getId(), epic1), manager.getAllEpic());
//        assertEquals(Map.of(subtask1.getId(), subtask1), manager.getAllTask());
//    }

    @Test
    public void throwManagerSaveExceptionTest() {

        filePath = Path.of("probablyShouldFinallyFall.exe");

        assertThrows(ManagerSaveException.class, () -> FileBackedTasksManager.loadFromFile(filePath));

    }
}
