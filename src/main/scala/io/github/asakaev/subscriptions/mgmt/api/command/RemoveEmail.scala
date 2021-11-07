package io.github.asakaev.subscriptions.mgmt.api.command

import io.github.asakaev.subscriptions.mgmt.shared.aggregate.User
import io.github.asakaev.subscriptions.mgmt.shared.model.{Email, UserId}
import io.github.asakaev.subscriptions.mgmt.shared.persistence.Store

object RemoveEmail {

  type RemoveEmail = Command => Unit

  final case class Command(uid: UserId, email: Email)

  /** Invariant (business rule) — when you remove an email, subscriptions are deactivated
    */
  def removeEmail(u: User, cmd: Command): User = {
    val xs = u.subscriptions.filter(_.email != cmd.email)
    val ys = u.emails.filter(_ != cmd.email)
    User(xs, ys)
  }

  def make(store: Store[UserId, User]): RemoveEmail = ???

}
