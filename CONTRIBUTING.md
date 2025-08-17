# Contributing to Infinite Dev Chain

Welcome! This repository is an *open, collaborative chain* where every developer adds a small, meaningful piece on top of others. The goal is to keep contributions tiny but thoughtful, and to maintain a healthy repo via CI and review.

## Principles

- **Tiny diffs, clear intent.** Prefer small, focused PRs that are easy to understand and review.
- **Leave it better.** If you touch a file, improve naming, tests, docs, or structure.
- **Language tracks are independent.** Each language folder has its own tooling and tests. Touch only what you need.
- **Automate the boring.** Follow CI feedback; add or fix script hooks if they help the next person.
- **Respect the current phase.**  
  In Phase 1 (early gameplay), creativity and interface design are prioritized over strict tests.  
  See [Game Phases](docs/GAME_PHASES.md) for details.

## How to contribute

1. **Fork** the repo and create a feature branch from `main`:
   ```bash
   git checkout -b feat/short-title
   ```

2. **Make a small change.** Examples:
   - A tiny library function with a test.
   - A refactor and a short rationale in the PR description.
   - Documentation improvements.
   - A minimal spike placed in `spikes/` (optional and short-lived).
   - In Phase 1: prefer designing interfaces, abstractions, or stubs that others can extend.  
     A complete working implementation is optional at this stage.
   - In later phases: follow strict rules (tests, docs, CI gates).

3. **Add tests** (if your change touches executable code).
   - **JavaScript**: put tests in `languages/javascript/__tests__/` and run `npm test`.
   - **Python**: put tests under `languages/python/tests/` and run `pytest`.
   - **Kotlin**: put tests under `languages/kotlin/test/` and run `./gradlew test`.

4. **Run the local checks** (if present):
   - JS: `npm run lint` / `npm test`
   - Python: `pytest` (or `ruff` / `pytest -q` if configured)
   - Kotlin: `./gradlew build` or `./gradlew test`

5. **Commit message** (short, imperative mood). If you’re closing an issue, include `Fixes #123`.

6. **Open a PR** using the template. Fill in the *Context*, *Changes*, *Tests*, and *Risk* sections. Keep it short and clear.

## CI Overview

- CI runs selectively by language. It only executes jobs for language tracks that changed in the PR (JS / Python / Kotlin).
- Each detected track runs:
  - **Install & bootstrap** (toolchain + deps if present).
  - **Lint & style checks** (only if the track has these tools configured).
  - **Tests + coverage** (publishes or enforces minimums when configured).
- One aggregate check named **`CI`** must be green before merge.

If tools are not yet configured for a language, CI will **not** fail; steps are guarded (e.g., `--if-present` or optional scripts). The first PR that adds real tooling should wire up scripts and configs for that language.

## Code style & format

- **Follow the conventions used in the language track you touch.**
- If you introduce a formatter/linter:
  - JS: prefer ESLint and Prettier.
  - Python: prefer Ruff (lint+format) and Black (format) if desired.
  - Kotlin: prefer ktlint and detekt.
- Provide minimal config files and npm/poetry/gradle scripts so others can run them easily.

## Tests & coverage

- New code generally requires tests.  
- **Exception**: during Phase 1, tests are encouraged but not strictly enforced. From Phase 2 onward, tests are mandatory with ≥80% coverage.  
- Keep tests readable and colocated under the language track’s test directory.

## Repository structure (high level)

- `.github/` — workflows, issue & PR templates, Auto Labeler, CodeQL, Dependabot.
- `docs/` — README, rules, governance, FAQ, tours.
- `languages/` — language-specific tracks (JS, Python, Kotlin).
- `incubator/`, `proposals/`, `spikes/` — optional spaces to stage ideas before promoting them into a language track.
- `tools/` — CI helpers, hooks, scripts.

## Labels

- `good-first-issue`, `help-wanted`, `infra`, `docs`, `refactor`, `tests`, `feature`, `bug`, `proposal`.
- The labeler workflow will auto-apply some labels based on changed paths.

## PR size & scope

- Prefer PRs with < ~200 additions net. Split your work if larger.
- Avoid drive-by changes across many tracks in one PR unless it’s clearly mechanical and low risk.

## Proposals

For bigger ideas, create an issue or add a short doc under `proposals/` and open a PR. Keep it brief: the problem, the proposed direction, and how to validate it.

## Code of Conduct

Be kind. We follow a lightweight social contract: assume good intent, be specific, and keep reviews constructive. If you see something off, open an issue.

## License

By contributing, you agree that your contributions are licensed under the repository’s LICENSE.

## Getting help

Open an issue with the `question` label or ask in the PR.
