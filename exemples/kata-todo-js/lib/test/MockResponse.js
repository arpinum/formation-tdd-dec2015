'use strict';

function MockResponse() {
  var self = this;
  self.json = json;
  self.status = status;
  self.end = end;

  function json(object) {
    self.jsonArg = object;
  }

  function status(s) {
    self.statusArg = s;
    return self;
  }

  function end() {
    self.endCalled = true;
    return self;
  }
}

module.exports = MockResponse;
