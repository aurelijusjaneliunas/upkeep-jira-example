#!/bin/sh

GATLING_VERSION=$1

if [ ! -d "gatling" ]; then
  mkdir -p gatling
fi

if [ ! -d "gatling/gatling-charts-highcharts-bundle-${GATLING_VERSION}" ]; then
  curl https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/${GATLING_VERSION}/gatling-charts-highcharts-bundle-${GATLING_VERSION}-bundle.zip -o /tmp/gatling-charts-highcharts-bundle-${GATLING_VERSION}-bundle.zip
  unzip -o /tmp/gatling-charts-highcharts-bundle-${GATLING_VERSION}-bundle.zip -d gatling
fi
