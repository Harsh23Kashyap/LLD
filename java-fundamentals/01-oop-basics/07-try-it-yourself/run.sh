#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/main/java/learning/oop/practice7/*.java
java -cp out learning.oop.practice7.Practice7App
