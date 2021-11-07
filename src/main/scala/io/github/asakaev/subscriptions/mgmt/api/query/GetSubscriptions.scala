package io.github.asakaev.subscriptions.mgmt.api.query

import io.github.asakaev.subscriptions.mgmt.shared.aggregate.User
import io.github.asakaev.subscriptions.mgmt.shared.model.{Subscription, UserId}
import io.github.asakaev.subscriptions.mgmt.shared.persistence.Store

/** Sometimes the model and view model are the same, but it is essential to realize that they are
  * distinct models.
  *
  * Read side (query) should be natural to display.
  *
  * Write side (command) is the business logic, and there should be no presentation details.
  */
object GetSubscriptions {
  type GetSubscriptions = Query => List[Subscription]

  final case class Query(uid: UserId)

  def make(store: Store[UserId, User]): GetSubscriptions =
    q => {

      /** It can be the same storage where you put the aggregate. Or it can be a separate one.
        */
      val u: User = store.get(q.uid)

      /** Usually, this is a unique query to the database.
        */
      u.subscriptions.toList
    }

}
