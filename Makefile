setup: setup-ruby

setup-ruby:
	@gem install bundler
	@bundle

watch:
	@compass watch

build:
	@mvn clean install

sonar:
	@mvn sonar:sonar

test:
	@mvn test
