'use strict';

function TaskResource(repository) {
  var self = this;
  self.get = doGet;
  self.delete = doDelete;

  function doGet(request, response) {
    var entity = repository.first({id: request.params.id});
    if (!entity) {
      response.status(404).end();
    } else {
      response.json(entity);
    }
  }

  function doDelete(request, response) {
    repository.delete({id: request.params.id});
    response.status(200).end();
  }
}

module.exports = TaskResource;
