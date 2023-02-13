# Taskmin Version 1.0
> my personal flavor of To-Do List App  

I'm building a Terminal based task list application. I want to be able to run this at a command line or to be able to compile into it's own Terminal based application.  

## Application Requirements
1. The application creates numbered, editable task lists.
2. The application saves and loads lists as/from text files (.txt)
3. Upon running the software, a main menu displayed with the following options:  
``` 
(1) Create New List
(2) Load List
(3) Help
(0) Exit 
``` 
4. Selecting `Help` should display a screen of text that explains how the software works.  
	+ selecting `Exit` should exit the program
5. When selecting `Create New List`, the user should be prompted to enter a title for the list.
	- After which they are presented with the Task List view of an empty list. As tasks are added to the list, they should generate their own id and should be displayed here as well.
```
(1) Add Task
(2) Remove Task
(3) Change Title
(4) Save List
(0) Exit
```

6. The Task List control is as follows:  
	- Selecting `(1) Add Task` will prompt the user to describe the task. Once entered, the user will return to the list control view, the task should appear on the list
	- Selecting `(2) Remove Task` will prompt the user to enter a Task ID number. Once entered the task will be removed from the list and the user will be returned to the list control view
	- Selecting `(3) Change Title` will prompt the user to rename their list. Once entered, the user will return to the list control view, and the title should show the change.
	- Selecting `(4) Save List` should prompt the user to enter a file name to save the list under.
		- a default file name should be in place in the event the user does not enter a file name.
	- Selecting `(0) Exit` should end the list control loop, clear any existing list, and return the user to the main menu.
7. **From the main menu again**: If the user selects `(2) Load List`, the software will prompt the user to enter the file name of the list they wish to load.
	- if the file name the user entered is found it will load the list and populate the tasks.
	- the user will then be shown the list control view with their pre-made list of tasks.