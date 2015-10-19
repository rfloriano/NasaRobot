setup: setup-ruby

setup-ruby:
	@gem install bundler
	@bundle

watch:
	@compass watch
