package io.github.asakaev.subscriptions.mgmt.shared.model

import java.util.UUID

final case class UserId(value: UUID) extends AnyVal
object UserId {

  /** Wire protocol codecs (such as JSON) are inside the companion object.
    */
  def decode(s: String): Option[UserId] = ???
}
