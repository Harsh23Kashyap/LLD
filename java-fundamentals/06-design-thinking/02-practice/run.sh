#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/main/java/learning/design/practice/*.java
java -cp out learning.design.practice.DesignPracticeApp
