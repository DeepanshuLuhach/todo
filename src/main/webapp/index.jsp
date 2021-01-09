<!DOCTYPE html>
<html>
  <head>
    <title>ToDo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>    

    <script>
      var list = document.getElementById('task-list');
      var lastid = 0;
      function loadData() {
        document.getElementById("demo").innerHTML = "${allTasks}";
        const allTasks = "${allTasks}"
        console.log(allTasks);
        for (var j = 0; j < allTasks.length; j++){

            console.log(allTasks[j]);

            }
        allTasks.forEach((element, index, array) => {
          console.log(element.description); // 100, 200, 300
          console.log(index); // 0, 1, 2
          console.log(array); // same myArray object 3 times
      });

        var entry = document.createElement('li');
        entry.appendChild(document.createTextNode(firstname));
        entry.setAttribute('id','item'+lastid);
        entry.setAttribute('data-name',firstname); //added a data-name attribute for easier access to name
        var removeButton = document.createElement('button');
        removeButton.appendChild(document.createTextNode("remove"));
        removeButton.setAttribute('onClick','removeName("'+'item'+lastid+'")');
        entry.appendChild(removeButton);
        lastid+=1;
        list.appendChild(entry);
      }
      </script>
  </head>

  <body onload="loadData()">
    <div class="container-fluid">
    <h1>ToDo List</h1>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addTaskModal">
      Launch demo modal
    </button>
    </div>
    <div class="modal fade" id="addTaskModal" tabindex="-1" aria-labelledby="addTaskModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="addTaskModalLabel">Add a Task</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <form action="add">
            <div class="modal-body">
              <div class="mb-3">
                <label for="taskDescription" class="form-label">Task Description</label>
                <input type="text" class="form-control" id="taskDescription" name="taskDescription">
              </div>
              
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
        </div>
      </div>
    </div>
    <!-- <div >
      ${allTasks}
        <ul class="list-group" id="task-list">
          <c:forEach items="${allTasks}" var="task">
            ${task}
            <li class="list-group-item d-flex justify-content-between align-items-center" id="task" onclick="changeStatus(this)">
            <div class="d-none d-print-block" text="${task.id}" id="uuid" ></div>
            <p id="description" text="hello" >${task.description} </p>
            <div class="badge bg-primary rounded-pill" text="${task.status}" id="status"></div>
            </li>
          </c:forEach>
        </ul>
    </div> -->
    <h1>All Festival Information</h1>
    <table>
        <tr>
            <td>id:</td>
            <td>description:</td>
            <td>status:</td>
        </tr>
        <c:forEach items="${allTasks}" var="task">
          ${task}
          <tr>      
              <td>${task.id}</td>
              <td>${task.description}</td>
              <td>${task.status}</td>
          </tr>
      </c:forEach>
    </table> 
    <p id="demo"></p>
    <ul class="list-group" id="task-list"></ul>
  </body>



</html>
