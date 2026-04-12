#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/main/java/learning/collections/set/*.java
java -cp out learning.collections.set.SetAndHashSetApp
