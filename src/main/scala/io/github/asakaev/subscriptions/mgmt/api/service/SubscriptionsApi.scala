package io.github.asakaev.subscriptions.mgmt.api.service

import io.github.asakaev.subscriptions.mgmt.api.command.RemoveEmail.RemoveEmail
import io.github.asakaev.subscriptions.mgmt.api.command.Subscribe.{Command, Subscribe}
import io.github.asakaev.subscriptions.mgmt.api.query.GetSubscriptions.GetSubscriptions
import io.github.asakaev.subscriptions.mgmt.shared.model.{Subscription, UserId}

/** Public API (gRPC, http, etc.)
  *
  * There is no reason to combine all methods under one interface. But most likely, when
  * implementing a gRPC service or HTTP API a similar structure will appear one way or another.
  */
trait SubscriptionsApi {

  // command
  def subscribe(uid: String, subscription: String): Unit
  def removeEmail(uid: String, email: String): Unit

  // query
  def getSubscriptions(uid: String): List[Subscription]
}

object SubscriptionsApi {

  def make(
      subscribeCommand: Subscribe,
      removeEmailCommand: RemoveEmail,
      getSubscriptionsQuery: GetSubscriptions
  ): SubscriptionsApi =
    new SubscriptionsApi {

      /** Decoding failures should be reflected in the API
        */
      def subscribe(uid: String, subscription: String): Unit = {
        val u   = UserId.decode(uid).get
        val s   = Subscription.decode(subscription).get
        val cmd = Command(u, s)
        subscribeCommand(cmd)
      }

      def removeEmail(uid: String, email: String): Unit = ???

      def getSubscriptions(uid: String): List[Subscription] = ???
    }

}
