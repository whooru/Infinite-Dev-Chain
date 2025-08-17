package idc.application.services

import idc.domain.model.Feature

interface RegisterElement {
  fun register(feature: Feature): Feature
}
