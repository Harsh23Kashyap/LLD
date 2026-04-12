#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out \
  src/main/java/learning/structure/util/Greeter.java \
  src/main/java/learning/structure/app/CodeStructureApp.java
java -cp out learning.structure.app.CodeStructureApp
