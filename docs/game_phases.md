# 🧩 Game Phases

The Infinite Dev Chain evolves in distinct stages.\
These phases define how strict the rules are and how gameplay develops
over time.

---

## Phase 0 — Setup

- Prepare repository infrastructure (folders, docs, CI/CD).
- Define contributing rules and coding guidelines.
- Configure automated checks (linting, formatting, test runners).
- Enable basic security: Dependabot, CodeQL.

**Goal:** establish a strong foundation before real contributions begin.

---

## Phase 1 — Early Gameplay (Design‑First)

- Developers start contributing across multiple languages.
- **Design‑first focus:** prioritize *interfaces, abstractions, and contracts* (public APIs, data models/DTOs, protocols). Small runnable stubs/examples are welcome but optional if the design is clear.
- **Soft test policy:** tests are encouraged but not strictly enforced yet. It’s OK to add scaffolding and TODOs that make the design explicit.
- PRs are reviewed mainly for clarity, cohesion with docs, and future extensibility (is the interface readable, composable, and easy to evolve?). Creativity is prioritized over structure.
- Keep contributions small and focused; prefer composable building blocks over large features.
- Discover idioms per language inside `languages/<lang>/` and align lightweight examples with the emerging style.

**Goal:** grow the repository with diverse, well‑shaped ideas and a clear backbone of interfaces/abstractions.

---

## Phase 2 — Strict Mode

- Full CI/CD enforcement kicks in:
  - Lint + format checks.
  - Unit tests required for new/changed functionality.
  - Coverage threshold: **≥ 80%** (global; and per‑file where applicable).
  - Documentation updates required when behavior changes (code‑to‑docs checks).
- PRs that don't meet standards are blocked until fixed.

**Goal:** prevent chaos, maintain quality, and ensure project stability.

---

## Phase 3 — Scoring & Leaderboard

- Automated scoring is enabled (points awarded for contributions).
- Leaderboard is generated and published (GitHub Pages or external service).
- Bonus points for tests, docs, and improving coverage.
- Optionally, points can later integrate with crypto or tokens.

**Goal:** add competitive, game‑like progression while keeping quality high.

---

## Notes

- Scoring is active **from Phase 1 onward**, but enforcement remains lenient until Phase 2.
- The exact scoring formula is intentionally not disclosed — only high‑level guidelines are shared.
- Players should focus on fun, creativity, and collaboration.
