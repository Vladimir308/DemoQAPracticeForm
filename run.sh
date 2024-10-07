#!/usr/bin/env bash
echo "==> Running ${TEST_TYPE}..."

case "$TEST_TYPE" in
  "ui_tests")
    if [[ -z $BROWSER ]] ; then
      echo "Error: BROWSER must be set" >&2
      exit 1
    fi

    if [[ -z $BROWSER_SIZE ]] ; then
      echo "Error: BROWSER_SIZE must be set" >&2
      exit 1
    fi

    BROWSER_PLATFORM=$(echo "${BROWSER}" | awk '{print $1}')
    BROWSER_VERSION=$(echo "${BROWSER}" | awk '{print $2}')

    GRADLE_OPTS="${GRADLE_OPTS} -Dbrowser=${BROWSER_PLATFORM}"
    GRADLE_OPTS="${GRADLE_OPTS} -Dversion=${BROWSER_VERSION}"
    GRADLE_OPTS="${GRADLE_OPTS} -DwindowSize=${BROWSER_SIZE}"

    if [[ -n $REMOTE_URL ]] ; then
      GRADLE_OPTS="${GRADLE_OPTS} -Denv=remote -DremoteUrl=${REMOTE_URL}"
    else
      GRADLE_OPTS="${GRADLE_OPTS} -Denv=local"

    echo "Error: unable to run unknown tasks. Only ui_tests, mobile_tests, and api_tests are possible" >&2
    exit 1
esac

./gradlew clean "$TEST_TYPE" $GRADLE_OPTS