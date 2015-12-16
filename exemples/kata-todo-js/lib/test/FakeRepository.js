'use strict';

var _ = require('lodash');
var uuid = require('node-uuid');

function FakeRepository() {
  var self = this;
  self.add = add;
  self.all = all;
  self.first = first;
  self.delete = doDelete;

  var entities = [];

  function add(entity) {
    _.merge(entity, {id: uuid.v4()});
    entities.push(entity);
    return entity;
  }

  function all() {
    return entities;
  }

  function first(criteria) {
    return _.first(_.where(entities, criteria));
  }

  function doDelete(criteria) {
    _.remove(entities, function (e) {
      return _.isMatch(e, criteria);
    });
  }
}

module.exports = FakeRepository;
