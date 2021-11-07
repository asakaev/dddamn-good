package io.github.asakaev.subscriptions.mgmt.shared.model

final case class Email(value: String)
object Email {

  /** Validation with Smart Constructors (https://wiki.haskell.org/Smart_constructors)
    */
  def of(s: String): Option[Email] = ???
}
