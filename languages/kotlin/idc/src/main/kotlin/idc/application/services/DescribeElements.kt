package idc.application.services

import idc.application.dtos.ElementSummary
import idc.application.queries.DescribeElementsQuery

interface DescribeElements {
  fun handle(query: DescribeElementsQuery): List<ElementSummary>
}
