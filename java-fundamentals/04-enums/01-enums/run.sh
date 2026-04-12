#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/main/java/learning/enums/basics/*.java
java -cp out learning.enums.basics.EnumsApp
