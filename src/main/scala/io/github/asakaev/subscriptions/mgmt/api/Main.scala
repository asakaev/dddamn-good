package io.github.asakaev.subscriptions.mgmt.api

import io.github.asakaev.subscriptions.mgmt.api.command.{RemoveEmail, Subscribe}
import io.github.asakaev.subscriptions.mgmt.api.query.GetSubscriptions
import io.github.asakaev.subscriptions.mgmt.api.service.SubscriptionsApi
import io.github.asakaev.subscriptions.mgmt.shared.persistence.Store

object Main extends App {

  val api: SubscriptionsApi =
    SubscriptionsApi.make(
      Subscribe.make(Store.live),
      RemoveEmail.make(Store.live),
      GetSubscriptions.make(Store.live)
    )

  // run server

}
