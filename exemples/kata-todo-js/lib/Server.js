'use strict';

var express = require('express');
var bodyParser = require('body-parser');
var TasksResource = require('./resources/TasksResource');
var TaskResource = require('./resources/TaskResource');

function Server(dependencies) {
  this.start = start;

  function start() {
    var application = express();
    application.use(bodyParser.json());

    configureRoutes(application);

    var server = application.listen(3000, function () {
      console.log('Server running on port', server.address().port);
    });
  }

  function configureRoutes(application) {
    var tasksResource = new TasksResource(dependencies.taskRepository);
    application.get('/tasks', tasksResource.get);
    application.post('/tasks', tasksResource.post);

    var taskResource = new TaskResource(dependencies.taskRepository);
    application.get('/tasks/:id', taskResource.get);
    application.delete('/tasks/:id', taskResource.delete);
  }
}

module.exports = Server;
