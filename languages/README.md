# Languages

Language tracks live here. To add a new language `X`:

1. Create `languages/x/` with `src/` and `tests/` (or ecosystem equivalents).
2. Provide three commands: **lint**, **test**, **coverage** (or JaCoCo/XML etc.).
3. Add linter/formatter configs and minimal tests.
4. Update `tools/ci/changed_langs.sh` to detect your language.
5. Open a PR — GitHub Actions will pick it up (add a job in `ci.yml` if needed).

Examples:
- [JavaScript](./javascript/)
- [Python](./python/)
- [Kotlin](./kotlin/)