package io.github.asakaev.subscriptions.mgmt.shared.persistence

import io.github.asakaev.subscriptions.mgmt.shared.aggregate.User
import io.github.asakaev.subscriptions.mgmt.shared.model.UserId

/** Can be any implementation: Map[K, V], key-value DB, document store, relational DB...
  */
trait Store[K, V] {

  def get(k: K): V

  /** This operation must be atomic!
    */
  def update(k: K)(f: Option[V] => Option[V]): Unit
}

object Store {

  /** Real storage implementation
    */
  val live: Store[UserId, User] = ???
}
