package org.bitbucket.pshirshov.izumi.distage.provisioning.strategies

import org.bitbucket.pshirshov.izumi.distage.model.plan.ExecutableOp
import org.bitbucket.pshirshov.izumi.distage.provisioning.{OpResult, ProvisioningContext}

trait CustomStrategy {
  def handle(context: ProvisioningContext, op: ExecutableOp.CustomOp): Seq[OpResult]

}
