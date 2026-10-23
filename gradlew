#!/bin/bash

# Set default JDK
DEFAULT_JVM_OPTS='-Xmx6400m' "-Dorg.gradle.appname=gradle"

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD=maximum
warn () {
    echo "$*"
} >&2

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
nonstop=false
case "$(uname -s)" in
  CYGWIN* )
    cygwin=true
    ;;
  Darwin* )
    darwin=true
    ;;
  MSYS* | MINGW* )
    msys=true
    ;;
esac

# For Cygwin, ensure paths are in UNIX format before anything is touched.
if $cygwin ; then
    [ -n "$GRADLE_OPTS" ] && GRADLE_OPTS=$(cygpath --path --windows "$GRADLE_OPTS")
fi

# Attempt to set APP_HOME
app_home=$HOME
if [ -n "$APP_HOME" ]; then
    app_home=$APP_HOME
fi

# Resolve the location of the 'gradle' script
GRADLE_SCRIPT_DIR=$(cd "$(dirname "$0")" && pwd -P)
GRADLE_HOME=$(cd "$GRADLE_SCRIPT_DIR/.." && pwd -P)

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD=9223372036854775807
if [ -n "$MAX_FD" ]; then
    ulimit -n $MAX_FD || warn "Could not set maximum file descriptor limit to $MAX_FD"
fi

# Collect all arguments for the java command
JVM_OPTS=("$DEFAULT_JVM_OPTS")
JVM_OPTS+=("$JVM_OPTS")
JVM_OPTS+=("-Dorg.gradle.appname=$APP_BASE_NAME")
JVM_OPTS+=("-Dorg.gradle.home.dir=$GRADLE_HOME")

# Set up the classpath
CLASSPATH=$GRADLE_HOME/gradle/wrapper/gradle-wrapper.jar

# Run Gradle
exec java "${JVM_OPTS[@]}" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
