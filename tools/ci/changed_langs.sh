#!/usr/bin/env bash
# Detect which language folders changed in this PR/commit range.
set -euo pipefail

base="${GITHUB_BASE_REF:-origin/main}"
if ! git rev-parse --verify "$base" >/dev/null 2>&1; then
  base="$(git merge-base HEAD origin/main || echo HEAD~1)"
fi

CHANGED=$(git diff --name-only "$base"...HEAD || true)

js=false; py=false; kt=false
echo "$CHANGED" | grep -q '^languages/javascript/' && js=true || true
echo "$CHANGED" | grep -q '^languages/python/'     && py=true || true
echo "$CHANGED" | grep -q '^languages/kotlin/'     && kt=true || true

# The workflow expects these exact keys:
echo "JS=$( $js && echo true || echo false )"
echo "PY=$( $py && echo true || echo false )"
echo "KT=$( $kt && echo true || echo false )"