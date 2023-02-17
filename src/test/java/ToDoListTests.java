import com.kevinbooms.Task;
import com.kevinbooms.ToDoList;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ToDoListTests {

    @Test
    public void default_constructor_is_blank() {
        ToDoList list = new ToDoList();
        Assert.assertEquals(null, list.getTitle());
        Assert.assertTrue(list.getTasks().isEmpty());
    }

    @Test
    public void loaded_constructor_receives_parameters() {
        String title = "OOOOOOOOOOH, Laa-lalaaaaaaaa";
        List<Task> tasks = List.of();
        ToDoList list = new ToDoList(title);
        Assert.assertEquals(title, list.getTitle());
        Assert.assertEquals(tasks, list.getTasks());
    }

    @Test
    public void addTask_adds_Task_to_List() {
        ToDoList sutList = new ToDoList("Yuyuyuyiyi-yi-yiyiyi-yiyiyi-oh-hohohoho");
        Task sutTask = new Task(0, "Lalalala-la-lalala-lalala-whohohoho!");
        sutList.addTask(sutTask);
        Assert.assertEquals(List.of(sutTask), sutList.getTasks());
    }

    @Test
    public void removeTask_removes_Task_from_List() {
        Task sutTask = new Task(0, "Hahahahahahahahaha");
        ToDoList sutList = new ToDoList("Lolololololololol");
        sutList.addTask(sutTask);
        Assert.assertEquals(List.of(sutTask), sutList.getTasks());
        sutList.removeTask(sutTask);
        Assert.assertTrue(sutList.getTasks().isEmpty());
    }
}
