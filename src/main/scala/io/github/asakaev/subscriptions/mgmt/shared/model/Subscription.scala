package io.github.asakaev.subscriptions.mgmt.shared.model

import io.github.asakaev.subscriptions.mgmt.shared.model.Subscription.Topic

final case class Subscription(topic: Topic, email: Email)
object Subscription {

  final case class Topic(value: String) extends AnyVal

  def decode(s: String): Option[Subscription] = ???
}
