if ENV['COVERAGE']
  require 'simplecov'
  SimpleCov.start
end

require 'minitest/autorun'
require 'minitest/reporters'
Minitest::Reporters.use! [Minitest::Reporters::SpecReporter.new]
require 'minitest/unit'
require 'mocha/mini_test'
