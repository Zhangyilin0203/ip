# User Guide

## Introduction
Duke is a Personal Assistant Chatbot that helps a person to keep track of his or her tasks, including todo tasks, deadline tasks and events.

## Features 

### Add tasks
Add any one of the three types of tasks: `todo`, `deadline`, `event`.

For `deadline`, you need to add a due date. 

For `event`, you need to add the date of the event.

### Delete tasks
Delete a task from the current tasks you have.

### Complete tasks
Mark a task as done when you complete the task.

### Display all tasks
Display the tasks to view all the tasks you have currently.

### Search for tasks
Search for specific tasks by giving a keyword.

### Load tasks
Load tasks from a local `.txt` file. Everytime when Duke is open, all the tasks will automatically be loaded from the local file.

### Save tasks
Save tasks to a local .txt file. Everytime when the user makes some changes, the changed data will be automatically stored into the local file.

### Exit
Exit Duke by typing `bye`.


## Usage

### `todo` - Add todo task

* Add a todo task with task description.

* Example of usage: 

  `todo swimming`

* Expected outcome:

  ````
  ____________________________________________________________
  Got it. I've added this task:
  [T][✘]borrow book
  Now you have 1 tasks in the list.
  ____________________________________________________________
  ````
  
### `deadline` - Add deadline task

* Add a deadline task with task description and due date.

* Example of usage: 

  `deadline return book /by Sunday`

* Expected outcome:

  ````
  ____________________________________________________________
  Got it. I've added this task:
  [D][✘]return book (by: Sunday)
  Now you have 2 tasks in the list.
  ____________________________________________________________
  ````

### `event` - Add event

* Add an event with description and event date.

* Example of usage: 

  `event project /at Mon 2-4pm`

* Expected outcome:

  ````
  ____________________________________________________________
  Got it. I've added this task:
  [E][✘]project (at: Mon 2-4pm)
  Now you have 3 tasks in the list.
  ____________________________________________________________
  ````
  
 ### `delete` - Delete a task
 
 * Delete a specific task according to the given index.
 
 * Example of usage: 
 
   `delete 2`
 
 * Expected outcome:
 
   ````
   ____________________________________________________________
   Noted. I've removed this task: 
   [D][✘]return book (by: Oct 15 2019)
   Now you have 6 tasks in the list.
   ____________________________________________________________
   ````
   
 ### `done` - Complete a task
  
  * Mark a specific task as done when finish the task.
  
  * Example of usage: 
  
    `done 2`
  
  * Expected outcome:
  
    ````
    ____________________________________________________________
    Nice! I've marked this task as done:
    [D][✓]return book (by: Sunday)
    ____________________________________________________________
    ````
    
 ### `list` - Display tasks
  
  * Display all the tasks you currently have.
  
  * Example of usage: 
  
    `list`
  
  * Expected outcome:
  
    ````
    ____________________________________________________________
    1. [D][✘]sleep (by: 12:00)
    2. [D][✘]borrow book (by: 2020-1-1)
    3. [E][✘]go home (at: 20:20)
    ____________________________________________________________
    ````

    
### `find` - Find tasks
  
  * Find out all the tasks with the given keyword.
  
  * Example of usage: 
  
    `find borrow`
  
  * Expected outcome:
  
    ````
    ____________________________________________________________
    Here are the matching tasks in your list:
    1. [D][✘]borrow book (by: 2020-1-1)
    ____________________________________________________________
    ````
    
### `bye` - Exit Duke
  * Exit Duke.
  
  * Example of usageL
  
    `bye`
    
  * Expected outcome:
    
      ````
    ____________________________________________________________
      Bye. Hope to see you again soon
    ____________________________________________________________
      ````
