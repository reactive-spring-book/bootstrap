#!/usr/bin/env bash

cd ${GITHUB_WORKSPACE:-$(dirname $0)../../}
mkdir -p $HOME/.m2/
cp .travis.settings.xml $HOME/.m2/settings.xml
mvn -e -f $GITHUB_WORKSPACE/pom.xml  verify deploy