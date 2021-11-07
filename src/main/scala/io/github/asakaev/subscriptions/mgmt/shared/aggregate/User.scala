package io.github.asakaev.subscriptions.mgmt.shared.aggregate

import io.github.asakaev.subscriptions.mgmt.shared.model.{Email, Subscription}

/** A DDD aggregate in Scala can be expressed as a case class or a tuple (product in general)
  *
  * Aggregate is placed separately from the model because of specific meaning — the transactional
  * consistency of data within the structure. A read-modify-write operation with data inside an
  * aggregate must be atomic.
  *
  * For example, in the scenario "removing an email also deactivates subscriptions" both fields of
  * the structure must be changed at the same time.
  *
  * An aggregate is not data modeling, but behavior modeling.
  *
  * To better understand the essence of the DDD aggregate, read the Pat Helland paper:
  *
  * Life beyond Distributed Transactions: an Apostate’s Opinion
  * https://www.ics.uci.edu/~cs223/papers/cidr07p15.pdf
  */
final case class User(subscriptions: Set[Subscription], emails: Set[Email])
