'use strict';

require('chai').should();
var Fizzbuzz = require('./fizzbuzz');

describe('Fizzbuzz', function () {

    var elements;

    before(function () {
        elements = new Fizzbuzz().elements();
    });

    it('should return 100 elements', function () {
        elements.should.have.lengthOf(100);
    });

    it('should return "1" for 1', function () {
        fizzbuzz(1).should.equal('1');
    });

    it('should return "fizz" for 3', function () {
        fizzbuzz(3).should.equal('fizz');
    });

    it('should return "buzz" for 5', function () {
        fizzbuzz(5).should.equal('buzz');
    });

    it('should return "fizzbuzz" for 15', function () {
        fizzbuzz(15).should.equal('fizzbuzz');
    });

    function fizzbuzz(number) {
        return elements[number - 1];
    }
});
