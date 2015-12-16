'use strict';

var _ = require('lodash');

function Fizzbuzz() {

    this.elements = function () {
        return _.map(_.range(1, 101), function (index) {
            return valueOf(index);
        });
    };

    function valueOf(i) {
        if (i % 15 === 0) {
            return 'fizzbuzz';
        }
        if (i % 3 === 0) {
            return 'fizz';
        }
        if (i % 5 === 0) {
            return 'buzz';
        }
        return i.toString();
    }
}

module.exports = Fizzbuzz;
