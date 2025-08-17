package idc.domain.port

import idc.domain.model.ElementId
import idc.domain.model.Feature

interface ElementRepository {
  fun findAll(
    limit: Int? = null,
    tag: String? = null,
  ): List<Feature>

  fun findById(id: ElementId): Feature?

  fun save(feature: Feature): Feature

  fun exists(id: ElementId): Boolean
}
