package com.github.pshirshov.izumi.idealingua.il.parser.structure

import com.github.pshirshov.izumi.idealingua.il.parser.IDLParserContext
import com.github.pshirshov.izumi.idealingua.model.il.ast.raw.{ParsedId, RawNodeMeta}
import fastparse._
import NoWhitespace._
import com.github.pshirshov.izumi.idealingua.model.il.ast.InputPosition

class MetaAggregates(context: IDLParserContext) {
  import aggregates._
  def meta[_:P]: P[RawNodeMeta] = P(MaybeDoc ~ context.defConst.defAnnos)
    .map {
      case (d, a) => RawNodeMeta(d, a, InputPosition.Undefined)
    }

  def withMeta[T](defparser: => P[T])(implicit v: P[_]): P[(RawNodeMeta, T)] = {
    meta ~ defparser
  }

  def cstarting[T](keyword: => P[Unit], defparser: => P[T])(implicit v: P[_]): P[(RawNodeMeta, ParsedId, T)] = {
    withMeta(starting(keyword, defparser)).map {
      case (m, (i, t)) => (m, i, t)
    }
  }

  def cblock[T](keyword: => P[Unit], defparser: => P[T])(implicit v: P[_]): P[(RawNodeMeta, ParsedId, T)] = {
    withMeta(block(keyword, defparser)).map {
      case (m, (i, t)) => (m, i, t)
    }
  }

}