'use strict';

require('chai').should();
var TasksResource = require('./TaskResource');
var MockResponse = require('../test/MockResponse');
var FakeRepository = require('../test/FakeRepository');

describe('The task resource', function () {
  var resource;
  var repository;
  var response;

  beforeEach(function () {
    repository = new FakeRepository();
    resource = new TasksResource(repository);
    response = new MockResponse();
  });

  context('on get', function () {
    it('should respond with the specified task', function () {
      repository.add({text: 'my first task'});
      var entity = repository.add({text: 'my second task'});
      var request = {params: {id: entity.id}};

      resource.get(request, response);

      response.jsonArg.should.deep.equal({id: entity.id, text: 'my second task'});
    });

    it('should respond with a 404 if entity cannot be found', function () {
      var request = {params: {id: 'not found'}};

      resource.get(request, response);

      response.statusArg.should.equal(404);
      response.endCalled.should.be.true;
    });
  });

  context('on delete', function () {
    it('should delete the specified task', function () {
      var entity = repository.add({text: 'adios'});
      var request = {params: {id: entity.id}};

      resource.delete(request, response);

      response.statusArg.should.equal(200);
      response.endCalled.should.be.true;
      repository.all().should.be.empty;
    });
  });
});
