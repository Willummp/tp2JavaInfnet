import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {
    private TasksManager tasksManager;

    @BeforeEach
    void setUp() {
        tasksManager = new TasksManager();
    }

    @Test
    void testTasksInitialization() {
        Tasks task = new Tasks("Título", "Descrição");
        assertEquals("Título", task.getTitle());
        assertEquals("Descrição", task.getDescription());
        assertNotNull(task.getCreationDate());
        assertFalse(task.isCompleted());
    }

    @Test
    void testMarkTaskAsCompleted() {
        Tasks task = new Tasks("Título", "Descrição");
        assertFalse(task.isCompleted());
        task.markAsCompleted();
        assertTrue(task.isCompleted());
        assertNotNull(task.getCompletionDate());
    }

    @Test
    void testAddTask() {
        tasksManager.addTasks("Título", "Descrição");
        // Aqui podemos adicionar testes adicionais para garantir que a tarefa foi adicionada corretamente
        assertEquals(1, tasksManager.getPoints());
    }

    @Test
    void testMarkTaskAsCompletedInTasksManager() {
        tasksManager.addTasks("Título", "Descrição");
        tasksManager.markTasksAsCompleted(1);
        // Aqui podemos adicionar testes adicionais para garantir que a tarefa foi marcada como concluída corretamente
        assertTrue(tasksManager.getPoints() > 0);
    }

    @Test
    void testPointsCalculation() {
        tasksManager.addTasks("Título 1", "Descrição 1");
        tasksManager.addTasks("Título 2", "Descrição 2");
        tasksManager.addTasks("Título 3", "Descrição 3");
        tasksManager.markTasksAsCompleted(1);
        tasksManager.markTasksAsCompleted(2);
        tasksManager.markTasksAsCompleted(3);
        assertEquals(3, tasksManager.getPoints());
    }

    @Test
    void testPointsForMultipleCompletion() {
        tasksManager.addTasks("Título 1", "Descrição 1");
        tasksManager.addTasks("Título 2", "Descrição 2");
        tasksManager.addTasks("Título 3", "Descrição 3");
        tasksManager.addTasks("Título 4", "Descrição 4");
        tasksManager.addTasks("Título 5", "Descrição 5");
        tasksManager.markTasksAsCompleted(1);
        tasksManager.markTasksAsCompleted(2);
        tasksManager.markTasksAsCompleted(3);
        tasksManager.markTasksAsCompleted(4);
        tasksManager.markTasksAsCompleted(5);
        assertEquals(6, tasksManager.getPoints()); // 5 tasks completed + bonus for 3 tasks
    }
}
