package idc.application.dtos

/**
 * Read-side DTO to expose a safe, presentation-agnostic view of an element.
 */
data class ElementSummary(
  val id: String,
  val title: String,
  val tags: List<String>,
)
