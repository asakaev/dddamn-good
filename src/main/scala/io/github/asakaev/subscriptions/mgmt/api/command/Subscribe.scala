package io.github.asakaev.subscriptions.mgmt.api.command

import io.github.asakaev.subscriptions.mgmt.shared.aggregate.User
import io.github.asakaev.subscriptions.mgmt.shared.model.{Subscription, UserId}
import io.github.asakaev.subscriptions.mgmt.shared.persistence.Store

/** Everything about the "Subscribe" case is here. The Scala object is used as a module.
  */
object Subscribe {

  /** Use-case is modeled as a function
    *
    * There will be something like Result = Success | FailureA | FailureB instead of a Unit.
    */
  type Subscribe = Command => Unit

  /** Command — arguments from the user
    */
  final case class Command(uid: UserId, subscription: Subscription)
  object Command {
    def decode(s: String): Option[Command] = ???
  }

  /** Business logic is here
    *
    * If we draw an analogy with a fold, then an aggregate is an accumulator, and business logic is
    * a reducer.
    *
    * https://en.wikipedia.org/wiki/Unidirectional_Data_Flow_(computer_science)
    */
  def subscribe(u: User, cmd: Command): User = {

    /** There will be validations and errors in the result type.
      */
    User(u.subscriptions + cmd.subscription, u.emails + cmd.subscription.email)
  }

  def make(store: Store[UserId, User]): Subscribe =
    cmd =>
      store.update(cmd.uid) {
        case None =>
          // initial User value
          val u = User(Set.empty, Set.empty)
          Some(subscribe(u, cmd))
        case Some(u) => Some(subscribe(u, cmd))
      }

}
