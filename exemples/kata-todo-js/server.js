'use strict';

var Server = require('./lib/Server');
var FakeRepository = require('./lib/test/FakeRepository');

var dependencies = {
  taskRepository: new FakeRepository()
};

new Server(dependencies).start();
