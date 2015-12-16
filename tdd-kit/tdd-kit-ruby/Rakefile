require 'rake/testtask'
require 'rubocop/rake_task'

Rake::TestTask.new do |task|
  task.pattern = 'lib/**/*_test.rb'
end

RuboCop::RakeTask.new(:rubocop)

task :active_cover do
  ENV['COVERAGE'] = 'true'
end

task default: %w(rubocop active_cover test)
