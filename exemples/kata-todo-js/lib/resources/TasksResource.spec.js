'use strict';

var should = require('chai').should();
var TasksResource = require('./TasksResource');
var MockResponse = require('../test/MockResponse');
var FakeRepository = require('../test/FakeRepository');

describe('The tasks resource', function () {
  var resource;
  var repository;
  var response;

  beforeEach(function () {
    repository = new FakeRepository();
    resource = new TasksResource(repository);
    response = new MockResponse();
  });

  context('on get', function () {
    it('should respond with all tasks', function () {
      var entity = repository.add({text: 'my task'});

      resource.get(null, response);

      response.jsonArg.should.deep.equal([{id: entity.id, text: 'my task'}]);
    });
  });

  context('on post', function () {
    it('should add a new task', function () {
      var request = {body: {text: 'my new task'}};

      resource.post(request, response);

      repository.all().should.have.lengthOf(1);
      repository.all()[0].text.should.equal('my new task');
      response.statusArg.should.equal(201);
      should.exist(response.jsonArg.id);
    });
  });
});
