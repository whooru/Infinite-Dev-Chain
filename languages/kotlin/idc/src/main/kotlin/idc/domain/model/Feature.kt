package idc.domain.model

/**
 * Domain entity that describes a conceptual "feature" contributed by developers.
 * It is intentionally minimal and implementation-agnostic.
 */
data class Feature(
  val id: ElementId,
  val title: String,
  val summary: String?,
  val tags: Set<String> = emptySet(),
)
