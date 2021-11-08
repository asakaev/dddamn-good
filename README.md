# DDDamn good!

Welcome to the repository for DDDamn good!, a workshop taught by Akhtiam Sakaev, which introduces
attendees to Domain-Driven Design implementation in Scala.

https://jokerconf.com/en/talks/dddamn-good/

## Use-cases

1. The user can subscribe to interesting topics.
2. When you delete an email address, subscriptions to this email are deactivated.

## Project structure

* subscriptions — `Subscriptions` Bounded context
* mgmt — `Management` service inside `Subscriptions` context
* api — `mgmt` API which can be implemented as HTTP/gRPC or any other RPC server.
* shared — data structures that can be used by other apps that make up the `mgmt` service.

## Example of an app using 'shared'

An app that listens to events from neighboring apps. For example, apps of the `mgmt` service
or applications from neighboring contexts.

## TODO

- [ ] Tests
- [ ] Add user email
- [ ] Error descriptions as part of the model
- [ ] Publishing events for third party applications/contexts
