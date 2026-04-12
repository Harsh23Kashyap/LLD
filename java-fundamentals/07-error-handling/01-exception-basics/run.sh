#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/main/java/learning/errors/demo/*.java
java -cp out learning.errors.demo.ExceptionBasicsApp
