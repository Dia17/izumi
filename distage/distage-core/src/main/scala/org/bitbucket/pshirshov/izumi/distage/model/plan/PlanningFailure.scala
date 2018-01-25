package org.bitbucket.pshirshov.izumi.distage.model.plan

import org.bitbucket.pshirshov.izumi.distage.definition.{Binding, ImplDef}
import org.bitbucket.pshirshov.izumi.distage.model.DIKey


sealed trait PlanningFailure {}

object PlanningFailure {
  case class DuplicatedStatements(target: DIKey, ops: Seq[ExecutableOp]) extends PlanningFailure
  case class UnsolvableConflict(target: DIKey, ops: Seq[ExecutableOp]) extends PlanningFailure
  case class UnbindableBinding(binding: Binding, defs: Seq[ImplDef]) extends PlanningFailure
}