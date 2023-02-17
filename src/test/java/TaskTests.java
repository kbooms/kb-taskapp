import com.kevinbooms.Task;

import org.junit.Assert;
import org.junit.Test;

public class TaskTests {

    Task sutTaskOne = new Task (1, "Test Task 1");
    Task sutTaskTwo = new Task (2, "Test Task 2");
    Task sutTaskThree = new Task (3, "Test Task 3, bruh");

    @Test
    public void loaded_constructor_receives_parameters() {
        int id = 0;
        String description = "Be sure to take out the trash";
        Task sutTask = new Task(id, description);
        Assert.assertEquals(id, sutTask.getId());
        Assert.assertEquals(description, sutTask.getDescription());
    }
    @Test
    public void get_id_returns_id() {
        Assert.assertEquals(1, sutTaskOne.getId());
        Assert.assertEquals(2, sutTaskTwo.getId());
        Assert.assertEquals(3, sutTaskThree.getId());
    }
    @Test
    public void get_description_returns_description() {
        Assert.assertEquals("Test Task 1", sutTaskOne.getDescription());
        Assert.assertEquals("Test Task 2", sutTaskTwo.getDescription());
        Assert.assertEquals("Test Task 3, bruh", sutTaskThree.getDescription());
    }
    @Test
    public void set_description_changes_description() {
        String change = "Description updated/changed!";
        sutTaskOne.setDescription(change);
        sutTaskTwo.setDescription(change);
        sutTaskThree.setDescription(change);

        Assert.assertEquals(change, sutTaskOne.getDescription());
        Assert.assertEquals(change, sutTaskTwo.getDescription());
        Assert.assertEquals(change, sutTaskThree.getDescription());
    }
}
