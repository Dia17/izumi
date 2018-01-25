package org.bitbucket.pshirshov.izumi.distage.model.plan

import org.bitbucket.pshirshov.izumi.distage.model.plan.ExecutableOp.{ImportDependency, InstantiationOp}
import org.bitbucket.pshirshov.izumi.distage.model.plan.ExecutableOp.SetOp._

case class NextOps(
                    imports: Set[ImportDependency]
                    , sets: Set[CreateSet]
                    , provisions: Seq[InstantiationOp]
                  ) {
  def flatten: Seq[ExecutableOp] = {
    imports.toSeq ++ sets.toSeq ++ provisions
  }
}
