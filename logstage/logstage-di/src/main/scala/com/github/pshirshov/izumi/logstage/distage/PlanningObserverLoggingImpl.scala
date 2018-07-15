package com.github.pshirshov.izumi.logstage.distage

import com.github.pshirshov.izumi.distage.model.plan.{DodgyPlan, FinalPlan}
import com.github.pshirshov.izumi.distage.model.planning.PlanningObserver
import com.github.pshirshov.izumi.logstage.api.IzLogger

class PlanningObserverLoggingImpl(log: IzLogger) extends PlanningObserver {
  override def onSuccessfulStep(next: DodgyPlan): Unit = {
    log.trace(s"DIStage performed planning step:\n$next")
  }

  override def onPhase00PlanCompleted(plan: DodgyPlan): Unit = {
    log.debug(s"[onPhase00PlanCompleted]:\n$plan")
  }

  override def onPhase10PostFinalization(plan: FinalPlan): Unit = {
    log.debug(s"[onPhase10PostOrdering]:\n$plan")
  }

  override def onPhase20Customization(plan: FinalPlan): Unit = {
    log.debug(s"[onPhase15PostOrdering]:\n$plan")
  }

  override def onPhase50PreForwarding(plan: FinalPlan): Unit = {
    log.debug(s"[onPhase20PreForwarding]:\n$plan")
  }

  override def onPhase90AfterForwarding(plan: FinalPlan): Unit = {
    log.debug(s"[onPhase30AfterForwarding]:\n$plan")
  }


}


