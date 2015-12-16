'use strict';

function TasksResource(repository) {
  var self = this;
  self.get = doGet;
  self.post = doPost;

  function doGet(request, response) {
    response.json(repository.all());
  }

  function doPost(request, response) {
    var entity = repository.add(request.body);
    response.status(201).json({id: entity.id});
  }
}

module.exports = TasksResource;
