#!/usr/bin/env bash
set -euo pipefail

LIMIT=${1:-400}

echo "Checking PR size (limit: $LIMIT net additions)..."

# GitHub provides diff in FETCH_HEAD vs base
diffstat=$(git diff --shortstat origin/main...HEAD)
additions=$(git diff --numstat origin/main...HEAD | awk '{adds+=$1} END {print adds}')

echo "Additions: $additions"
if [ "$additions" -gt "$LIMIT" ]; then
  echo "⚠️ PR too large ($additions > $LIMIT). Consider splitting."
  exit 0  # soft guard, doesn’t fail
fi