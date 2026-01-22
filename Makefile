# SPDX-FileCopyrightText: Copyright © 2026 Caleb Cushing
#
# SPDX-License-Identifier: MIT

HEAD := $(shell git rev-parse --verify HEAD)
GRADLE_DIR := $(wildcard ./.gradle/)
BUILD_DIRS := $(wildcard ./build/)
CONFIGURATION_CACHE := $(wildcard $(GRADLE_DIR)configuration-cache/)

.PHONY: up
up:
# success if no output
	./gradlew dependencies --write-locks --console=plain | grep -e FAILED || exit 0

.PHONY: build
build:
	./gradlew build --console=plain

.PHONY: clean
clean:
	./gradlew clean

.PHONY: cleaner
cleaner: clean-build clean-gradle

clean-cc: $(CONFIGURATION_CACHE)
	- rm -rf $(CONFIGURATION_CACHE)

ci-build:
	./gradlew build --build-cache --scan

ci-full:
	./gradlew build --no-build-cache --no-configuration-cache --scan

ci-update-java: clean-lockfiles up-wrapper up

clean-build:
	- rm -rf $(BUILD_DIRS)

clean-gradle:
	- rm -rf $(GRADLE_DIR)

clean-lockfiles:
	find . -name '*gradle.lockfile' -delete

up-wrapper:
	./gradlew wrapper --write-locks && ./gradlew wrapper
